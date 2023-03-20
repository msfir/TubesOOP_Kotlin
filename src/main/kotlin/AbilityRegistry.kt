package tubes.oop

import tubes.oop.entities.Ability

class AbilityRegistry {
    private val abilities = mutableListOf<Ability>()

    fun registerAbility(ability: Ability) {
        abilities.add(ability)
    }

    fun getAbilities(): List<Ability> = abilities.toList()
}