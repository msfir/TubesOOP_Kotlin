package tubes.oop.entities.cards

import tubes.oop.entities.Card
import tubes.oop.extensions.AnsiCode
import tubes.oop.extensions.ansi

class RedCard(override val number: Int) : Card(number) {
    override fun equals(other: Any?): Boolean = other is RedCard && other.number == this.number

    override fun value(): Double = number + 3 * .03
    override fun toString(): String = "$number (Merah)".ansi(AnsiCode.BOLD, AnsiCode.FG_RED)
    override fun hashCode(): Int = number.hashCode() * 31 + (3).hashCode()
}