package tubes.oop

import tubes.oop.states.Configuration
import tubes.oop.states.PlayerRegistration

class GameEngine() {
    private val manager = GameManager()

    init {
        manager.stateRegistry.registerState("configuration", Configuration())
        manager.stateRegistry.registerState("player registration", PlayerRegistration())
    }

    fun start() {
        var state = manager.stateRegistry.getState("configuration")
        while (!state.isEnd()) {
            state = state.updateState(manager)
        }
        // final state
        state.updateState(manager)
    }
}