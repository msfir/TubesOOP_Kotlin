package tubes.oop.entities.cards

import tubes.oop.entities.Card
import tubes.oop.extensions.AnsiCode
import tubes.oop.extensions.ansi

class YellowCard(override val number: Int) : Card(number) {
    override fun equals(other: Any?): Boolean = other is YellowCard && other.number == this.number

    override fun value(): Double = number + 2 * .03
    override fun toString(): String = "$number (Kuning)".ansi(AnsiCode.BOLD, AnsiCode.FG_YELLOW)
    override fun hashCode(): Int = (number.hashCode() * 31) + (2).hashCode()

}