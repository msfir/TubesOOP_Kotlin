package tubes.oop.states

import tubes.oop.GameManager
import tubes.oop.GameState

class RoundSetup : GameState {
    override fun updateState(manager: GameManager): GameState {
        if (manager.currentRound == 1) {
            manager.currentPlayerIndex = 0
            manager.currentRoundPlayerTurnQueue.clear()
            manager.currentRoundPlayerTurnQueue.addAll(listOf(1, 2, 3, 4, 5, 6))
            manager.nextRoundPlayerTurnQueue.clear()
            manager.nextRoundPlayerTurnQueue.addAll(listOf(1, 2, 3, 4, 5, 6, 0))
            distributeCards(manager)
        } else {
            manager.currentPlayerIndex = manager.nextRoundPlayerTurnQueue.first()
            manager.nextRoundPlayerTurnQueue.removeFirst()
            manager.currentRoundPlayerTurnQueue.clear()
            manager.currentRoundPlayerTurnQueue.addAll(manager.nextRoundPlayerTurnQueue)
            manager.nextRoundPlayerTurnQueue.add(manager.currentPlayerIndex)
        }
        if (manager.currentRound < 6) {
            manager.table.putCard(manager.deck.takeCard())
        }
        if (manager.currentRound == 2) {
            distributeAbilities(manager)
        }
        return manager.stateRegistry.getState("dashboard")
    }

    private fun distributeAbilities(manager: GameManager) {
        val abilities = manager.abilityRegistry.getAbilities().shuffled()
        for ((player, ability) in manager.players.zip(abilities)) {
            player.ability = ability.withManager(manager)
        }
    }

    private fun distributeCards(manager: GameManager) {
        for (player in manager.players) {
            player.setCards(Pair(manager.deck.takeCard(), manager.deck.takeCard()))
        }
    }

    override fun isEnd(): Boolean = false
}