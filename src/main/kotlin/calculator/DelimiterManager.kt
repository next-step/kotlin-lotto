package calculator

object DelimiterManager {
    private const val SEPARATOR = "|"

    fun generateRegex(delimiters: List<String>): Regex = delimiters.joinToString(SEPARATOR).toRegex()
}
