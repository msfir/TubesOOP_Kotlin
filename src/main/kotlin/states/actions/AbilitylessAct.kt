package tubes.oop.states.actions

import tubes.oop.GameManager
import tubes.oop.GameState
import tubes.oop.entities.abilities.Abilityless
import tubes.oop.extensions.ansi
import tubes.oop.globals.ANSI_NAME
import tubes.oop.globals.ANSI_SPECIAL_TEXT
import tubes.oop.globals.inputValidate
import tubes.oop.globals.validateAbility
import tubes.oop.states.Action

class AbilitylessAct : Action() {
    override fun updateState(manager: GameManager): GameState {
        val player = manager.currentPlayer
        val ability = player.ability
        if (!validateAbility(ability, "Abilityless")) {
            return manager.stateRegistry.getState("player command")
        }
        println("${player.name.ansi(*ANSI_NAME)} menggunakan ability ${"Abilityless".ansi(*ANSI_SPECIAL_TEXT)}!")
        println("${player.name.ansi(*ANSI_NAME)} akan mematikan kartu ability lawan!")
        if (manager.players.filter { it !== player }.all { it.ability!!.used }) {
            println("Eits, ternyata semua pemain sudah memakai kartu kemampuan. " +
                    "Yah kamu kena sendiri deh, kemampuanmu menjadi abilityless. " +
                    "Yah, pengunaan kartu ini sia-sia")
            ability!!.used = true
            return manager.stateRegistry.getState("next")
        }
        val players = manager.players.filter { it.name != player.name }.toList()
        println("Silahkan pilih pemain yang kartunya ingin anda matikan:")
        players.withIndex().forEach {
            println("\t${it.index + 1}. ${it.value.name.ansi(*ANSI_NAME)}")
        }
        val targetIdx = inputValidate(1, 6)
        val target = players[targetIdx - 1]
        if (target.ability!!.used) {
            println("Kartu ability ${target.name.ansi(*ANSI_NAME)} telah dipakai sebelumnya. " +
                    "Yah, sayang penggunaan kartu ini sia-sia")
            ability!!.used = true
            return manager.stateRegistry.getState("next")
        }
        ability!!.withAdditionalArgs(mapOf(Abilityless.Args.TARGET to target)).use()
        println("Kartu ability ${target.name.ansi(*ANSI_NAME)} telah dimatikan.")

        return manager.stateRegistry.getState("next")
    }
}