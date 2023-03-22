package tubes.oop.entities.abilities

import tubes.oop.entities.Ability

class Quarter : Ability() {
    override val name: String
        get() = "Quarter"

    override fun use() {
        manager.pot /= 4

        used = true
    }
}