package tubes.oop.states.actions

import tubes.oop.GameManager
import tubes.oop.GameState
import tubes.oop.extensions.ansi
import tubes.oop.globals.ANSI_NAME
import tubes.oop.globals.ANSI_SPECIAL_TEXT
import tubes.oop.globals.validateAbility
import tubes.oop.states.Action

class QuarterAct : Action() {
    override fun updateState(manager: GameManager): GameState {
        val player = manager.currentPlayer
        val ability = player.ability
        if (!validateAbility(ability, "Quarter")) {
            return manager.stateRegistry.getState("player command")
        }
        println("${player.name.ansi(*ANSI_NAME)} menggunakan ability ${"Quarter".ansi(*ANSI_SPECIAL_TEXT)}!")
        print("Poin hadiah telah berubah dari ${manager.pot.toString().ansi(*ANSI_SPECIAL_TEXT)} menjadi ")
        ability!!.use()
        println(manager.pot.toString().ansi(*ANSI_SPECIAL_TEXT))
        return manager.stateRegistry.getState("next")
    }
}