package tubes.oop.entities

import tubes.oop.GameManager

abstract class Ability(val name: String) {
    private var _owner: Player? = null
    private var _manager: GameManager? = null
    private var _additionalArgs: Map<String, Any> = emptyMap()

    protected val owner get() = _owner!!
    protected val manager get() = _manager!!
    protected val additionalArgs get() = _additionalArgs

    var used = false
    var muted = false

    fun withOwner(player: Player): Ability {
        _owner = player
        return this
    }

    fun withManager(manager: GameManager): Ability {
        this._manager = manager
        return this
    }

    fun withAdditionalArgs(args: Map<String, Any>): Ability {
        _additionalArgs = args.toMap()
        return this
    }
    fun mute() {
        muted = true
    }

    abstract fun use()
}
