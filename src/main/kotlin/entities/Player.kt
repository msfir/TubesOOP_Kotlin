package tubes.oop.entities

class Player(val name: String) {
    enum class Side { LEFT, RIGHT }

    var points: Long = 0
    var ability: Ability?
        get() = ability?.withOwner(this)
        set(value) {
            ability = value
        }

    private val _cards = mutableListOf<Card>()
    val cards get() = _cards.toList()

    fun setCards(left: Card, right: Card) {
        if (_cards.isEmpty()) {
            _cards.add(left)
            _cards.add(right)
        } else {
            _cards[0] = left
            _cards[1] = right
        }
    }

    fun setCards(cards: List<Card>) {
        setCards(cards[0], cards[1])
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