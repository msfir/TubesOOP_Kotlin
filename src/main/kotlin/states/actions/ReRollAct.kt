package tubes.oop.states.actions

import tubes.oop.GameManager
import tubes.oop.GameState
import tubes.oop.entities.abilities.ReRoll
import tubes.oop.extensions.ansi
import tubes.oop.globals.ANSI_NAME
import tubes.oop.globals.ANSI_SPECIAL_TEXT
import tubes.oop.states.Action

class ReRollAct : Action() {
    override fun updateState(manager: GameManager): GameState {
        val player = manager.currentPlayer
        val ability = player.ability
        if (ability !is ReRoll) {
            println("Kamu tidak punya ability ${"RE-ROLL".ansi(*ANSI_SPECIAL_TEXT)}!")
            return manager.stateRegistry.getState("player command")
        }
        println("${player.name.ansi(*ANSI_NAME)} menggunakan ability ${"RE-ROLL".ansi(*ANSI_SPECIAL_TEXT)}!")
        println("Membuang kartu yang dimiliki...")
        ability.use()
        val (left, right) = player.cards
        println("Kartu kamu sekarang adalah $left dan $right")
        return manager.stateRegistry.getState("next")
    }
}