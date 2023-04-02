package tubes.oop.entities

import kotlin.random.Random

class Deck {
    private val _cards = mutableListOf<Card>()
    val cards get() = _cards.toList()

    fun putCard(card: Card) {
        _cards.add(card)
    }

    fun takeCard(): Card = _cards.removeLast()

    fun clear() = _cards.clear()

    fun shuffle() = _cards.shuffle(Random(System.nanoTime()))
}