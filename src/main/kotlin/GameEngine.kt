package tubes.oop

import tubes.oop.entities.abilities.*
import tubes.oop.entities.combos.*
import tubes.oop.states.*
import tubes.oop.states.actions.*
import tubes.oop.states.actions.Double

class GameEngine {
    private val manager = GameManager()

    init {
        with(manager.stateRegistry) {
            registerState("player registration", PlayerRegistration())
            registerState("game setup", GameSetup())
            registerState("round setup", RoundSetup())
            registerState("dashboard", Dashboard())
            registerState("player command", PlayerCommand())
            registerState("next", Next())
            registerState("double", Double())
            registerState("half", Half())
            registerState("quarter", QuarterAct())
            registerState("quadruple", QuadrupleAct())
            registerState("re-roll", ReRollAct())
            registerState("reverse", ReverseAct())
            registerState("swap", SwapAct())
            registerState("switch", SwitchAct())
            registerState("abilityless", AbilitylessAct())
            registerState("card calculation", CardCalculation())
            registerState("conclusion", Conclusion())
            registerState("end", End())
        }
        with(manager.abilityRegistry) {
            registerAbility(Quadruple())
            registerAbility(Quarter())
            registerAbility(ReRoll())
            registerAbility(Reverse())
            registerAbility(Swap())
            registerAbility(Switch())
            registerAbility(Abilityless())
        }
        with(manager.comboRegistry) {
            registerCombo(HighCard())
            registerCombo(Pair())
            registerCombo(TwoPair())
            registerCombo(ThreeOfAKind())
            registerCombo(Flush())
            registerCombo(FullHouse())
            registerCombo(Straight())
            registerCombo(FourOfAKind())
            registerCombo(StraightFlush())
        }
    }

    fun start() {
        var state = manager.stateRegistry.getState("player registration")
        while (!state.isEnd()) {
            state = state.updateState(manager)
        }
        // final state
        state.updateState(manager)
    }
}