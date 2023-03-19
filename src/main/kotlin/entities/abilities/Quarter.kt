package tubes.oop.entities.abilities

import tubes.oop.entities.Ability

class Quarter : Ability() {
    override fun use() {
        manager!!.pot /= 4
    }
}