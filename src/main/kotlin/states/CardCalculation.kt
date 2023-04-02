package tubes.oop.states

import tubes.oop.GameManager
import tubes.oop.GameState
import tubes.oop.entities.Combo
import tubes.oop.entities.combos.HighCard
import tubes.oop.extensions.AnsiCode
import tubes.oop.extensions.ansi
import tubes.oop.globals.ANSI_BORDER
import tubes.oop.globals.ANSI_NAME
import tubes.oop.globals.ANSI_TITLE

class CardCalculation : GameState {
    override fun updateState(manager: GameManager): GameState {
        println(
            "=======[".ansi(*ANSI_BORDER) +
                    " Card Calculation ".ansi(*ANSI_TITLE) +
                    "]======".ansi(*ANSI_BORDER)
        )
        val combos = manager.comboRegistry.getCombos()
        val players = manager.players
        val tableCards = manager.table.cards
        for (player in players) {
            var strongestCombo: Combo = HighCard()
            var value = .0
            for (combo in combos) {
                if (combo.isThereCombo(player.cards, tableCards) && combo.value() > value) {
                    strongestCombo = combo.clone()
                    value = combo.value()
                }
            }
            player.combo = strongestCombo
        }
        println("Daftar combo yang dimiliki pemain:")
        players.withIndex().forEach {
            println(
                "\t${it.index + 1}. ${it.value.name.ansi(*ANSI_NAME)}: " +
                        "${it.value.combo.name.ansi(AnsiCode.UNDERLINE)} (" +
                        "${it.value.combo.cards.joinToString(", ")})"
            )
        }
        val winner = players.maxBy { it.combo.value() }
        println("Pemilik combo terkuat adalah ${winner.name.ansi(*ANSI_NAME)}")
        println("Poin hadiah yang dimenangkan adalah sebesar ${manager.pot.toString().ansi(AnsiCode.UNDERLINE)}")
        winner.points += manager.pot
        if (winner.points < (1L).shl(32)) {
            return manager.stateRegistry.getState("game setup")
        } else {
            TODO("conclusion state is not implemented yet")
        }
    }

    override fun isEnd(): Boolean = false
}