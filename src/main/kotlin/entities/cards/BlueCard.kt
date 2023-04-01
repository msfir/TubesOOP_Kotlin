package tubes.oop.entities.cards

import tubes.oop.entities.Card
import tubes.oop.extensions.AnsiCode
import tubes.oop.extensions.ansi

class BlueCard(override val number: Int) : Card(number) {
    override fun equals(other: Any?): Boolean = other is BlueCard && other.number == this.number

    override fun value(): Double = number + 1 * .03
    override fun toString(): String = "$number (Biru)".ansi(AnsiCode.BOLD, AnsiCode.FG_BLUE)
    override fun hashCode(): Int = (number.hashCode() * 31) + (1).hashCode()
}