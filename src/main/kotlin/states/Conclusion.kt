package tubes.oop.states

import tubes.oop.GameManager
import tubes.oop.GameState
import tubes.oop.extensions.AnsiCode
import tubes.oop.extensions.ansi
import tubes.oop.globals.ANSI_BORDER
import tubes.oop.globals.ANSI_NAME
import tubes.oop.globals.ANSI_TITLE
import tubes.oop.globals.inputValidate

class Conclusion : GameState {
    override fun updateState(manager: GameManager): GameState {
        println("Permainan berakhir!".ansi(AnsiCode.BOLD, AnsiCode.FG_BRIGHT_RED))
        println(
            "==========[".ansi(*ANSI_BORDER) +
                    " Leaderboard ".ansi(*ANSI_TITLE) +
                    "]=========".ansi(*ANSI_TITLE)
        )
        val players = manager.players.sortedByDescending { it.points }
        players.withIndex().forEach { 
            println("\t${it.index + 1}. ${it.value.name.ansi(*ANSI_NAME)}: ${it.value.points}")
        }
        println("Permainan dimenangkan oleh ${players.first().name.ansi(*ANSI_NAME)}!")
        println("Lanjut?")
        println("\t1. Main lagi")
        println("\t2. Exit")
        val ans = inputValidate(1, 2)
        return if (ans == 1) {
            manager.stateRegistry.getState("player registration")
        } else {
            manager.stateRegistry.getState("end")
        }
    }

    override fun isEnd(): Boolean = false
}