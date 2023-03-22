package tubes.oop.states.actions

import tubes.oop.GameManager
import tubes.oop.GameState
import tubes.oop.extensions.ansi
import tubes.oop.globals.ANSI_COMMAND
import tubes.oop.globals.ANSI_NAME
import tubes.oop.globals.ANSI_SPECIAL_TEXT
import tubes.oop.states.Action

class Half : Action() {
    override fun updateState(manager: GameManager): GameState {
        val player = manager.currentPlayer
        println("${player.name.ansi(*ANSI_NAME)} melakukan ${"HALF".ansi(*ANSI_COMMAND)}!")
        print("Poin hadiah telah berubah dari ${manager.pot.toString().ansi(*ANSI_SPECIAL_TEXT)} menjadi ")
        manager.pot /= 2
        println(manager.pot.toString().ansi(*ANSI_SPECIAL_TEXT))
        return manager.stateRegistry.getState("next")
    }
}