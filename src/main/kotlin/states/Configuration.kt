package tubes.oop.states

import tubes.oop.GameManager
import tubes.oop.GameState
import tubes.oop.entities.Deck
import tubes.oop.entities.cards.BlueCard
import tubes.oop.entities.cards.GreenCard
import tubes.oop.entities.cards.RedCard
import tubes.oop.entities.cards.YellowCard

class Configuration : GameState {
    private fun fillDeck(deck: Deck) {
        for (i in 1..13) {
            deck.putCard(GreenCard(i))
            deck.putCard(BlueCard(i))
            deck.putCard(YellowCard(i))
            deck.putCard(RedCard(i))
        }
    }

    override fun updateState(manager: GameManager): GameState {
        fillDeck(manager.deck)
        manager.deck.shuffle()
        return manager.stateRegistry.getState("player registration")
    }

    override fun isEnd(): Boolean = false
}