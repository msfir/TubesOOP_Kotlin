package tubes.oop.states.actions

import tubes.oop.GameManager
import tubes.oop.GameState
import tubes.oop.entities.abilities.Switch
import tubes.oop.extensions.ansi
import tubes.oop.globals.ANSI_NAME
import tubes.oop.globals.ANSI_SPECIAL_TEXT
import tubes.oop.globals.inputValidate
import tubes.oop.globals.validateAbility
import tubes.oop.states.Action

class SwitchAct : Action() {
    override fun updateState(manager: GameManager): GameState {
        val player = manager.currentPlayer
        val ability = player.ability
        if (!validateAbility(ability, "Switch")) {
            return manager.stateRegistry.getState("player command")
        }
        println("${player.name.ansi(*ANSI_NAME)} menggunakan ability ${"Switch".ansi(*ANSI_SPECIAL_TEXT)}!")
        println("Kartumu sekarang adalah ${player.leftCard} dan ${player.rightCard}")
        val players = manager.players.filter { it.name != player.name }.toList()
        println("Silahkan pilih pemain yang kartunya ingin anda tukar:")
        players.withIndex().forEach {
            println("\t${it.index + 1}. ${it.value.name.ansi(*ANSI_NAME)}")
        }
        val targetIdx = inputValidate(1, 6)
        val target = players[targetIdx - 1]
        ability!!.withAdditionalArgs(mapOf(Switch.Args.TARGET to target)).use()
        println("Kedua kartu ${player.name.ansi(*ANSI_NAME)} telah ditukar dengan ${target.name.ansi(*ANSI_NAME)}")
        println("Kartumu sekarang adalah ${player.leftCard} dan ${player.rightCard}")

        return manager.stateRegistry.getState("next")
    }
}