package tubes.oop.entities.cards

import tubes.oop.entities.Card

class RedCard(private val number: Int) : Card(number) {
    override fun value(): Double = number + 3 * .003
    override fun toString(): String = "$number (Merah)"
}