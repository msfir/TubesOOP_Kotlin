package tubes.oop.globals

import tubes.oop.extensions.AnsiCode

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
        if (result == null || result !in lower..upper) {
            println("Masukan tidak valid!")
        }
    } while (result !in lower..upper)
    return result!!
}