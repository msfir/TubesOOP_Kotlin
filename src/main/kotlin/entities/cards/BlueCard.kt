package tubes.oop.entities.cards

import tubes.oop.entities.Card

class BlueCard(override val number: Int) : Card(number) {
    override fun value(): Double = number + 1 * .003
    override fun toString(): String = "$number (Biru)"
}