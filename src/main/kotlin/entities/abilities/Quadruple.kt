package tubes.oop.entities.abilities

import tubes.oop.entities.Ability

class Quadruple : Ability("Quadruple") {
    override fun use() {
        manager.pot *= 4

        used = true
    }
}