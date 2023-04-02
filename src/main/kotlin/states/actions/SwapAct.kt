package tubes.oop.states.actions

import tubes.oop.GameManager
import tubes.oop.GameState
import tubes.oop.entities.abilities.Swap
import tubes.oop.extensions.ansi
import tubes.oop.globals.ANSI_NAME
import tubes.oop.globals.ANSI_SPECIAL_TEXT
import tubes.oop.globals.inputValidate
import tubes.oop.globals.validateAbility
import tubes.oop.states.Action

class SwapAct : Action() {
    override fun updateState(manager: GameManager): GameState {
        val player = manager.currentPlayer
        val ability = player.ability
        if (!validateAbility(ability, "Swap")) {
            return manager.stateRegistry.getState("player command")
        }
        println("${player.name.ansi(*ANSI_NAME)} menggunakan ability ${"Swap".ansi(*ANSI_SPECIAL_TEXT)}!")
        val players = manager.players.filter { it.name != player.name }.toMutableList()

        println("Silahkan pilih pemain yang kartunya ingin anda tukar:")
        players.withIndex().forEach {
            println("\t${it.index + 1}. ${it.value.name.ansi(*ANSI_NAME)}")
        }
        var targetIdx = inputValidate(1, 6)
        val target1 = players[targetIdx - 1]
        players.removeAt(targetIdx - 1)

        println("Silahkan pilih pemain lain yang kartunya ingin anda tukar:")
        players.withIndex().forEach {
            println("\t${it.index + 1}. ${it.value.name.ansi(*ANSI_NAME)}")
        }
        targetIdx = inputValidate(1, 5)
        val target2 = players[targetIdx - 1]

        println("Silahkan pilih kartu kanan/kiri ${target1.name.ansi(*ANSI_NAME)}:")
        println("\t1. Kiri")
        println("\t2. Kanan")
        val target1Side = inputValidate(1, 2)

        println("Silahkan pilih kartu kanan/kiri ${target2.name.ansi(*ANSI_NAME)}:")
        println("\t1. Kiri")
        println("\t2. Kanan")
        val target2Side = inputValidate(1, 2)

        ability!!.withAdditionalArgs(
            mapOf(
                Swap.Args.FIRST_TARGET to target1,
                Swap.Args.SECOND_TARGET to target2,
                Swap.Args.FIRST_TARGET_SIDE to target1Side,
                Swap.Args.SECOND_TARGET_SIDE to target2Side
            )
        ).use()

        return manager.stateRegistry.getState("next")
    }
}