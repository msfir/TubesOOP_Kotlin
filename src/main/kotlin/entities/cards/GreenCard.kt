package tubes.oop.entities.cards

import tubes.oop.entities.Card

class GreenCard(private val number: Int): Card(number) {

    override fun value(): Double = number + 0 * .003

    override fun toString(): String = "$number (Hijau)"
}