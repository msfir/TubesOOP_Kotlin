package tubes.oop

import tubes.oop.entities.Deck
import tubes.oop.entities.Player
import tubes.oop.entities.Table

class GameManager {
    val players = mutableListOf<Player>()
    val currentRoundPlayerTurnQueue = mutableListOf<Int>()
    val nextRoundPlayerTurnQueue = mutableListOf<Int>()
    val deck = Deck()
    val table = Table()
    val stateRegistry = GameStateRegistry()
    val abilityRegistry = AbilityRegistry()
    var pot = 0L
    var currentRound = 0
    var currentPlayerIndex = 0
    val currentPlayer get() = players[currentPlayerIndex]
}