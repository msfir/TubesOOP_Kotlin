package tubes.oop.globals

import tubes.oop.entities.Ability
import tubes.oop.extensions.AnsiCode
import tubes.oop.extensions.ansi

val ANSI_NAME = intArrayOf(AnsiCode.BOLD, AnsiCode.FG_BRIGHT_YELLOW)
val ANSI_BORDER = intArrayOf(AnsiCode.FG_CYAN)
val ANSI_TITLE = intArrayOf(AnsiCode.BOLD, AnsiCode.FG_CYAN)
val ANSI_SPECIAL_TEXT = intArrayOf(AnsiCode.BOLD, AnsiCode.FG_BRIGHT_GREEN)
val ANSI_COMMAND = intArrayOf(AnsiCode.BOLD, AnsiCode.FG_BRIGHT_GREEN)

fun inputValidate(lower: Int, upper: Int) : Int {
    var result: Int?
    do {
        print("> ")
        result = readln().trim().toIntOrNull()
        if (result === null || result !in lower..upper) {
            println("Masukan tidak valid!")
        }
    } while (result !in lower..upper)
    return result!!
}

fun validateAbility(ability: Ability?, name: String) : Boolean {
    return when {
        ability === null -> {
            println("Kamu belum punya ability!")
            false
        }
        ability.name != name -> {
            println("Kamu tidak punya ability ${name.ansi(*ANSI_SPECIAL_TEXT)}!")
            false
        }
        ability.used -> {
            println("Ability ini sudah digunakan sebelumnya!")
            false
        }
        ability.muted -> {
            println("Ability ini sudah dimatikan oleh pemain lain!")
            false
        }
        else -> true
    }
}