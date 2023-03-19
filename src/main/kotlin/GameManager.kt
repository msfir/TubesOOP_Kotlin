package tubes.oop

import tubes.oop.entities.Card
import tubes.oop.entities.Deck
import tubes.oop.entities.Player
import tubes.oop.entities.Table

class GameManager {
    private val _players = mutableListOf<Player>()

    val players get() = _players.toList()
    var pot: Long = 0
    var deck = Deck()
    var table = Table()

    fun registerPlayer(player: Player) {

    }

    fun fillDeck(deck: Deck) {

    }

}