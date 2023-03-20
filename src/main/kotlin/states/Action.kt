package tubes.oop.states

import tubes.oop.GameState

abstract class Action : GameState {
    override fun isEnd(): Boolean = false
}