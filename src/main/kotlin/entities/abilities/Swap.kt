package tubes.oop.entities.abilities

import tubes.oop.entities.Ability
import tubes.oop.entities.Player

class Swap : Ability("Swap") {
    object Args {
        const val FIRST_TARGET = "first target"
        const val SECOND_TARGET = "second target"
        const val FIRST_TARGET_SIDE = "first target side"
        const val SECOND_TARGET_SIDE = "second target side"
    }

    override fun use() {
        val target1 = additionalArgs[Args.FIRST_TARGET] as Player
        val target2 = additionalArgs[Args.SECOND_TARGET] as Player
        val side1 = additionalArgs[Args.FIRST_TARGET_SIDE] as Int
        val side2 = additionalArgs[Args.SECOND_TARGET_SIDE] as Int
        val card1 = if (side1 == 1) target1.leftCard else target1.rightCard
        val card2 = if (side2 == 1) target2.leftCard else target2.rightCard
        if (side1 == 1) {
            target1.leftCard = card2
        } else {
            target1.rightCard = card2
        }
        if (side2 == 1) {
            target2.leftCard = card1
        } else {
            target2.rightCard = card1
        }
        used = true
    }
}