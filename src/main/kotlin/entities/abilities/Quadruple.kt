package tubes.oop.entities.abilities

import tubes.oop.entities.Ability

class Quadruple : Ability() {
    override fun use() {
        manager!!.pot *= 4
    }
}