package tubes.oop

class GameStateRegistry {
    private val states = mutableMapOf<String, GameState>()

    fun registerState(name: String, state: GameState) {
        states[name] = state
    }
    fun getState(name: String) = states[name]!!
}