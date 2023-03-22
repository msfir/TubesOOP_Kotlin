package tubes.oop.entities.abilities

import tubes.oop.entities.Ability

class ReRoll : Ability() {
    override val name: String
        get() = "Re-roll"

    override fun use() {
        val cards = Pair(manager.deck.takeCard(), manager.deck.takeCard())
        owner.setCards(cards)

        used = true
    }
}