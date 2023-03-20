package tubes.oop.states

import tubes.oop.GameManager
import tubes.oop.GameState
import tubes.oop.entities.Player
import tubes.oop.extensions.ansi
import tubes.oop.globals.ANSI_NAME

class PlayerRegistration : GameState {
    override fun updateState(manager: GameManager): GameState {
        var i = 1
        outer@ while (i <= 7) {
            print("Masukkan nama player ke-$i: ")
            val nickname = readln()
            for (p in manager.players) {
                if (p.name == nickname) {
                    println("Player dengan nama ${nickname.ansi(*ANSI_NAME)} sudah pernah terdaftar! Silahkan mengambil nama yang lain")
                    continue@outer
                }
            }
            println("${nickname.ansi(*ANSI_NAME)} telah didaftarkan sebagai player ke-$i!")
            val player = Player(nickname)
            manager.players.add(player)
            i++
        }
        return manager.stateRegistry.getState("game setup")
    }

    override fun isEnd(): Boolean = false
}