package tubes.oop.entities.abilities

import tubes.oop.entities.Ability
import tubes.oop.entities.Player

class Swap : Ability() {
    object Args {
        const val FIRST_TARGET = "first target"
        const val SECOND_TARGET = "second target"
        const val FIRST_TARGET_SIDE = "first target side"
        const val SECOND_TARGET_SIDE = "second target side"
    }

    override fun use() {
        val target1 = additionalArgs[Args.FIRST_TARGET] as Player
        val target2 = additionalArgs[Args.SECOND_TARGET] as Player
        val side1 = additionalArgs[Args.FIRST_TARGET_SIDE] as Player.Side
        val side2 = additionalArgs[Args.SECOND_TARGET_SIDE] as Player.Side
        val card1 = target1.getCard(side1)
        val card2 = target2.getCard(side2)
        target1.setCard(card2, side1)
        target2.setCard(card1, side2)

        used = true
    }
}