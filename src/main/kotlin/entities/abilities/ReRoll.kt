package tubes.oop.entities.abilities

import tubes.oop.entities.Ability

class ReRoll : Ability("Re-Roll") {
    override fun use() {
        owner.setCards(manager.deck.takeCard(), manager.deck.takeCard())

        used = true
    }
}