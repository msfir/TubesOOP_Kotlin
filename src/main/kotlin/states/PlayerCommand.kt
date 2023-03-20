package tubes.oop.states

import tubes.oop.GameManager
import tubes.oop.GameState
import tubes.oop.extensions.AnsiCode
import tubes.oop.extensions.ansi

class PlayerCommand : GameState {
    override fun updateState(manager: GameManager): GameState {
        print("> ")
        val command = readln().trim()
        try {
            val action = manager.stateRegistry.getState(command)
            if (action !is Action) {
                println("Tidak ada aksi bernama ${command.ansi(AnsiCode.BOLD, AnsiCode.FG_BRIGHT_RED)}!")
                return this
            }
            return action
        } catch (e: NullPointerException) {
            println("Tidak ada aksi bernama ${command.ansi(AnsiCode.BOLD, AnsiCode.FG_BRIGHT_RED)}!")
            return this
        }
    }

    override fun isEnd(): Boolean = false
}