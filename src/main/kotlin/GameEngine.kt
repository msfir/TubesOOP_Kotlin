package tubes.oop

import tubes.oop.entities.abilities.*
import tubes.oop.states.*
import tubes.oop.states.actions.*
import tubes.oop.states.actions.Double

class GameEngine() {
    private val manager = GameManager()

    init {
        manager.stateRegistry.registerState("configuration", Configuration())
        manager.stateRegistry.registerState("player registration", PlayerRegistration())
        manager.stateRegistry.registerState("game setup", GameSetup())
        manager.stateRegistry.registerState("round setup", RoundSetup())
        manager.stateRegistry.registerState("dashboard", Dashboard())
        manager.stateRegistry.registerState("player command", PlayerCommand())
        manager.stateRegistry.registerState("next", Next())
        manager.stateRegistry.registerState("double", Double())
        manager.stateRegistry.registerState("half", Half())
        manager.stateRegistry.registerState("quarter", QuarterAct())
        manager.stateRegistry.registerState("quadruple", QuadrupleAct())
        manager.stateRegistry.registerState("re-roll", ReRollAct())
        manager.stateRegistry.registerState("reverse", ReverseAct())
        manager.stateRegistry.registerState("swap", SwapAct())
        manager.stateRegistry.registerState("switch", SwitchAct())
        manager.stateRegistry.registerState("abilityless", AbilitylessAct())

        manager.abilityRegistry.registerAbility(Quadruple())
        manager.abilityRegistry.registerAbility(Quarter())
        manager.abilityRegistry.registerAbility(ReRoll())
        manager.abilityRegistry.registerAbility(Reverse())
        manager.abilityRegistry.registerAbility(Swap())
        manager.abilityRegistry.registerAbility(Switch())
        manager.abilityRegistry.registerAbility(Abilityless())
    }

    fun start() {
        var state = manager.stateRegistry.getState("configuration")
        while (!state.isEnd()) {
            state = state.updateState(manager)
        }
        // final state
        state.updateState(manager)
    }
}