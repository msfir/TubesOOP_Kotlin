package tubes.oop

import tubes.oop.entities.Combo

class ComboRegistry {
    private val combos = mutableListOf<Combo>()

    fun registerCombo(combo: Combo) {
        combos.add(combo)
    }

    fun getCombos(): List<Combo> = combos.toList()
}