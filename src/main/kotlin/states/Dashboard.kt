package tubes.oop.states

import tubes.oop.GameManager
import tubes.oop.GameState
import tubes.oop.extensions.ansi
import tubes.oop.globals.*

class Dashboard : GameState {
    override fun updateState(manager: GameManager): GameState {
        print("==========[ ".ansi(*ANSI_BORDER))
        print("Dashboard".ansi(*ANSI_TITLE))
        print(" ]==========".ansi(*ANSI_BORDER))
        println()
        println("• Ronde ke: ${manager.currentRound.toString().ansi(*ANSI_SPECIAL_TEXT)}")
        println("• Poin hadiah: ${manager.pot.toString().ansi(*ANSI_SPECIAL_TEXT)}")
        println("• Kartu di meja:")
        manager.table.cards.withIndex().forEach { (i, card) -> println("\t${i + 1}. $card") }
        println("=".repeat(33).ansi(*ANSI_BORDER))
        println("• Nama pemain: ${manager.currentPlayer.name.ansi(*ANSI_NAME)}")
        println("• Kartu di tangan:")
        val (left, right) = manager.currentPlayer.cards
        println("\tKiri: $left")
        println("\tKanan: $right")
        return manager.stateRegistry.getState("player command")
    }

    override fun isEnd(): Boolean = false
}