package tubes.oop.states

import tubes.oop.GameManager
import tubes.oop.GameState

class GameSetup : GameState {
    override fun updateState(manager: GameManager): GameState {
        manager.pot = 64
        manager.currentRound = 1
        manager.currentPlayerIndex = 0

        return manager.stateRegistry.getState("round setup")
    }

    override fun isEnd(): Boolean = false
}