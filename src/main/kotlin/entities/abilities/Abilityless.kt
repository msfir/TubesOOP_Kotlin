package tubes.oop.entities.abilities

import tubes.oop.entities.Ability
import tubes.oop.entities.Player

class Abilityless : Ability("Abilityless") {
    object Args {
        const val TARGET = "target"
    }

    override fun use() {
        val target = additionalArgs[Args.TARGET] as Player
        target.ability!!.mute()
        used = true
    }
}