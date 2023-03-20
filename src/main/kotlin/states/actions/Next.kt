package tubes.oop.states.actions

import tubes.oop.GameManager
import tubes.oop.GameState
import tubes.oop.extensions.ansi
import tubes.oop.globals.ANSI_NAME
import tubes.oop.states.Action

class Next : Action() {
    override fun updateState(manager: GameManager): GameState {
        if (manager.currentRoundPlayerTurnQueue.isEmpty()) {
            manager.currentRound++
            println("Giliran dilanjut ke ${manager.currentPlayer.name.ansi(*ANSI_NAME)}")
            return manager.stateRegistry.getState("round setup")
        } else {
            manager.currentPlayerIndex = manager.currentRoundPlayerTurnQueue.first()
            manager.currentRoundPlayerTurnQueue.removeFirst()
            println("Giliran dilanjut ke ${manager.currentPlayer.name.ansi(*ANSI_NAME)}")
            return manager.stateRegistry.getState("dashboard")
        }
    }
}