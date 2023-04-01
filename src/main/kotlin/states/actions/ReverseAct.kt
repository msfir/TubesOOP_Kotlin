package tubes.oop.states.actions

import tubes.oop.GameManager
import tubes.oop.GameState
import tubes.oop.entities.abilities.Reverse
import tubes.oop.extensions.ansi
import tubes.oop.globals.ANSI_NAME
import tubes.oop.globals.ANSI_SPECIAL_TEXT
import tubes.oop.states.Action

class ReverseAct : Action() {
    override fun updateState(manager: GameManager): GameState {
        val player = manager.currentPlayer
        val ability = player.ability
        if (ability !is Reverse) {
            println("Kamu tidak punya ability ${"REVERSE".ansi(*ANSI_SPECIAL_TEXT)}!")
            return manager.stateRegistry.getState("player command")
        }
        println("${player.name.ansi(*ANSI_NAME)} menggunakan ability ${"REVERSE".ansi(*ANSI_SPECIAL_TEXT)}!")
        ability.use()
        print("Sisa urutan giliran ronde ini: ")
        println(manager.currentRoundPlayerTurnQueue.joinToString(", ") {
            manager.players[it].name.ansi(*ANSI_NAME)
        })
        print("Urutan giliran ronde berikutnya: ")
        println(manager.nextRoundPlayerTurnQueue.joinToString(", ") {
            manager.players[it].name.ansi(*ANSI_NAME)
        })
        return manager.stateRegistry.getState("player command")
    }
}