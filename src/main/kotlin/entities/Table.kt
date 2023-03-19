package tubes.oop.entities

class Table {
    private val _cards = mutableListOf<Card>()
    val cards get() = _cards.toList()

    fun putCard(card: Card) {
        _cards.add(card)
    }

    fun clear() {
        _cards.clear()
    }
}