package tubes.oop.states

import tubes.oop.GameManager
import tubes.oop.GameState

class End : GameState {
    override fun updateState(manager: GameManager): GameState {
        println("Bye-bye!")
        return this
    }

    override fun isEnd(): Boolean = true
}