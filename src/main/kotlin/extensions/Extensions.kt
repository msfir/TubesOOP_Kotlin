package tubes.oop.extensions

object AnsiCode {
    const val BOLD              = 1
    const val DIM               = 2
    const val ITALIC            = 3
    const val UNDERLINE         = 4
    const val BLINKING          = 5
    const val INVERSE           = 7
    const val INVISIBLE         = 8
    const val STRIKETHROUGH     = 9
    const val FG_BLACK          = 30
    const val FG_RED            = 31
    const val FG_GREEN          = 32
    const val FG_YELLOW         = 33
    const val FG_BLUE           = 34
    const val FG_MAGENTA        = 35
    const val FG_CYAN           = 36
    const val FG_WHITE          = 37
    const val FG_DEFAULT        = 39
    const val BG_BLACK          = 40
    const val BG_RED            = 41
    const val BG_GREEN          = 42
    const val BG_YELLOW         = 43
    const val BG_BLUE           = 44
    const val BG_MAGENTA        = 45
    const val BG_CYAN           = 46
    const val BG_WHITE          = 47
    const val BG_DEFAULT        = 49
    const val FG_BRIGHT_BLACK   = 90
    const val FG_BRIGHT_RED     = 91
    const val FG_BRIGHT_GREEN   = 92
    const val FG_BRIGHT_YELLOW  = 93
    const val FG_BRIGHT_BLUE    = 94
    const val FG_BRIGHT_MAGENTA = 95
    const val FG_BRIGHT_CYAN    = 96
    const val FG_BRIGHT_WHITE   = 97
    const val BG_BRIGHT_BLACK   = 100
    const val BG_BRIGHT_RED     = 101
    const val BG_BRIGHT_GREEN   = 102
    const val BG_BRIGHT_YELLOW  = 103
    const val BG_BRIGHT_BLUE    = 104
    const val BG_BRIGHT_MAGENTA = 105
    const val BG_BRIGHT_CYAN    = 106
    const val BG_BRIGHT_WHITE   = 107
}

fun String.ansi(vararg codes: Int): String {
    return "\u001b[${codes.joinToString(";")}m$this\u001b[0m"
}

fun String.fg256(id: UByte): String {
    return "\u001b[38;5;${id}m$this\u001b[0m"
}

fun String.bg256(id: UByte): String {
    return "\u001b[48;5;${id}m$this\u001b[0m"
}

fun String.fgRGB(r: UByte, g: UByte, b: UByte): String {
    return "\u001b[38;2;$r;$g;${b}m$this\u001b[0m"
}

fun String.bgRGB(r: UByte, g: UByte, b: UByte): String {
    return "\u001b[48;2;$r;$g;${b}m$this\u001b[0m"
}
