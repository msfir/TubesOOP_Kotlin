package tubes.oop.entities

class Player(val name: String) {
    enum class Side { LEFT, RIGHT }

    private var _ability: Ability? = null

    var points: Long = 0
    var ability
        get() = _ability?.withOwner(this)
        set(value) {
            _ability = value
        }

    private val _cards = mutableListOf<Card>()
    val cards get() = Pair(_cards[0], _cards[1])

    fun setCards(cards: Pair<Card, Card>) {
        if (_cards.isEmpty()) {
            _cards.add(cards.first)
            _cards.add(cards.second)
        } else {
            _cards[0] = cards.first
            _cards[1] = cards.second
        }
    }

    fun setCard(card: Card, side: Side) {
        when (side) {
            Side.LEFT -> _cards[0] = card
            Side.RIGHT -> _cards[1] = card
        }
    }

    fun getCard(side: Side): Card {
        return when (side) {
            Side.LEFT -> _cards[0]
            Side.RIGHT -> _cards[1]
        }
    }
}