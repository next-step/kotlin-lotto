package calculator

object DelimiterManager {
    private const val SEPARATOR = "|"

    fun generateRegex(delimiters: List<String>) = delimiters.joinToString(SEPARATOR) { Regex.escape(it) }.toRegex()
}
