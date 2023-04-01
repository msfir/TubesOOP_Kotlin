package tubes.oop.entities.abilities

import tubes.oop.entities.Ability

class Reverse : Ability("Reverse") {

    override fun use() {
        manager.currentRoundPlayerTurnQueue.reverse()
        val first = manager.nextRoundPlayerTurnQueue.first()
        manager.nextRoundPlayerTurnQueue.removeFirst()
        manager.nextRoundPlayerTurnQueue.reverse()
        manager.nextRoundPlayerTurnQueue.add(0, first)

        used = true
    }

}