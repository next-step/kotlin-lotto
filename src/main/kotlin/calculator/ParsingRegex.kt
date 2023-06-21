package calculator

fun interface ParsingRegex {
    fun find(text: String): MatchResult?
}
