package tubes.oop.entities.cards

import tubes.oop.entities.Card
import tubes.oop.extensions.AnsiCode
import tubes.oop.extensions.ansi

class GreenCard(override val number: Int) : Card(number) {
    override fun equals(other: Any?): Boolean = other is GreenCard && other.number == this.number

    override fun value(): Double = number + 0 * .03

    override fun toString(): String = "$number (Hijau)".ansi(AnsiCode.BOLD, AnsiCode.FG_GREEN)
    override fun hashCode(): Int = (number.hashCode() * 31) + (0).hashCode()
}