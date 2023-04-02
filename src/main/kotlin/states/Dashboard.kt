package tubes.oop.states

import tubes.oop.GameManager
import tubes.oop.GameState
import tubes.oop.extensions.ansi
import tubes.oop.globals.ANSI_BORDER
import tubes.oop.globals.ANSI_NAME
import tubes.oop.globals.ANSI_SPECIAL_TEXT
import tubes.oop.globals.ANSI_TITLE

class Dashboard : GameState {
    override fun updateState(manager: GameManager): GameState {
        if (manager.currentRound == 7) {
            return manager.stateRegistry.getState("card calculation")
        }
        val player = manager.currentPlayer
        print("==========[ ".ansi(*ANSI_BORDER))
        print("Dashboard".ansi(*ANSI_TITLE))
        print(" ]==========".ansi(*ANSI_BORDER))
        println()
        println("• Ronde ke: ${manager.currentRound.toString().ansi(*ANSI_SPECIAL_TEXT)}")
        println("• Poin hadiah: ${manager.pot.toString().ansi(*ANSI_SPECIAL_TEXT)}")
        println("• Kartu di meja:")
        manager.table.cards.withIndex().forEach { (i, card) -> println("\t${i + 1}. $card") }
        println("=".repeat(33).ansi(*ANSI_BORDER))
        println("• Nama pemain: ${player.name.ansi(*ANSI_NAME)}")
        println("• Kartu di tangan:")
        val (left, right) = player.cards
        println("\tKiri: $left")
        println("\tKanan: $right")
        try {
            val ability = player.ability!!
            print("• Kamu punya ability ${ability.name.ansi(*ANSI_SPECIAL_TEXT)}")
            if (ability.used) {
                println(" (sudah digunakan)")
            } else if (ability.muted) {
                println( " (sudah dimatikan)")
            } else {
                println()
            }
        } catch (e: NullPointerException) {
            println("• Kamu belum punya ability")
        }
        return manager.stateRegistry.getState("player command")
    }

    override fun isEnd(): Boolean = false
}