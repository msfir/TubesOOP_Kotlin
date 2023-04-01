package tubes.oop.entities.abilities

import tubes.oop.entities.Ability

class Quarter : Ability("Quarter") {
    override fun use() {
        manager.pot /= 4

        used = true
    }
}