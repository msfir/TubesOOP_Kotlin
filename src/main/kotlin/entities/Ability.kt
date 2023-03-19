package tubes.oop.entities

import tubes.oop.GameManager

abstract class Ability {
    protected var owner: Player? = null
    protected var manager: GameManager? = null
    protected var additionalArgs: Map<String, Any> = emptyMap()
    private var _used = false;
    private var _muted = false;

    var used
        get() = _used
        protected set(value) {
            _used = value
        }
    var muted
        get() = _muted
        protected set(value) {
            _muted = value
        }

    fun withOwner(player: Player): Ability {
        owner = player
        return this
    }

    fun withManager(manager: GameManager): Ability {
        this.manager = manager
        return this
    }

    fun withAdditionalArgs(args: Map<String, Any>): Ability {
        additionalArgs = args.toMap()
        return this
    }

    abstract fun use()
}
