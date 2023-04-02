package tubes.oop.entities

class Player(val name: String) {
    lateinit var leftCard: Card
    lateinit var rightCard: Card
    lateinit var combo: Combo

    private var _ability: Ability? = null

    var points: Long = 0
    var ability
        get() = _ability?.withOwner(this)
        set(value) {
            _ability = value
        }
    
    val cards get() = Pair(leftCard, rightCard)

    fun setCards(left: Card, right: Card) {
        leftCard = left
        rightCard = right
    }
    fun setCards(cards: Pair<Card, Card>) {
        leftCard = cards.first
        rightCard = cards.second
    }
}