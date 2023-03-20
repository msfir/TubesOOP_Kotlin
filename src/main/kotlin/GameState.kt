package tubes.oop

interface GameState {
    fun updateState(manager: GameManager): GameState
    fun isEnd(): Boolean
}