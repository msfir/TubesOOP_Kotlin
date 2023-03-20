package tubes.oop.entities.abilities

import tubes.oop.entities.Ability
import tubes.oop.entities.Player

class Switch : Ability() {
    object Args {
        const val TARGET = "target"
    }

    override fun use() {
        val target = additionalArgs[Args.TARGET] as Player
        val targetCards = target.cards
        val ownerCards = owner.cards
        target.setCards(ownerCards)
        owner.setCards(targetCards)

        used = true
    }
}