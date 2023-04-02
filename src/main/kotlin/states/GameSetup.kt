package tubes.oop.states

import tubes.oop.GameManager
import tubes.oop.GameState
import tubes.oop.entities.Deck
import tubes.oop.entities.cards.BlueCard
import tubes.oop.entities.cards.GreenCard
import tubes.oop.entities.cards.RedCard
import tubes.oop.entities.cards.YellowCard

class GameSetup : GameState {
    private fun fillDeck(deck: Deck) {
        for (i in 1..13) {
            deck.putCard(GreenCard(i))
            deck.putCard(BlueCard(i))
            deck.putCard(YellowCard(i))
            deck.putCard(RedCard(i))
        }
    }
    override fun updateState(manager: GameManager): GameState {
        manager.pot = 64
        manager.currentRound = 1
        manager.currentPlayerIndex = 0
        manager.deck.clear()
        fillDeck(manager.deck)
        manager.deck.shuffle()
        manager.players.forEach {
            it.setCards(manager.deck.takeCard(), manager.deck.takeCard())
            it.ability?.used = false
            it.ability?.muted = false
            it.ability = null
        }
        manager.table.clear()

        return manager.stateRegistry.getState("round setup")
    }

    override fun isEnd(): Boolean = false
}