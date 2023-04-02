package tubes.oop.states.actions

import tubes.oop.GameManager
import tubes.oop.GameState
import tubes.oop.extensions.ansi
import tubes.oop.globals.ANSI_NAME
import tubes.oop.globals.ANSI_SPECIAL_TEXT
import tubes.oop.globals.validateAbility
import tubes.oop.states.Action

class ReverseAct : Action() {
    override fun updateState(manager: GameManager): GameState {
        val player = manager.currentPlayer
        val ability = player.ability
        if (!validateAbility(ability, "Reverse")) {
            return manager.stateRegistry.getState("player command")
        }
        println("${player.name.ansi(*ANSI_NAME)} menggunakan ability ${"Reverse".ansi(*ANSI_SPECIAL_TEXT)}!")
        ability!!.use()
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