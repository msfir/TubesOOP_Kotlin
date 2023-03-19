package tubes.oop.entities.abilities

import tubes.oop.entities.Ability
import tubes.oop.entities.Player

class Swap : Ability() {
    object Args {
        val FIRST_TARGET = "firsttarget"
        val SECOND_TARGET = "secondtarget"
        val FIRST_TARGET_SIDE = "firsttargetside"
        val SECOND_TARGET_SIDE = "secondtargetside"
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
    }
}