package tubes.oop.entities.cards

import tubes.oop.entities.Card

class YellowCard(private val number: Int) : Card(number) {
    override fun value(): Double = number + 2 * .003
    override fun toString(): String = "$number (Kuning)"

}