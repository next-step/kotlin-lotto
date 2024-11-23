package calculator

object DelimiterRegexGenerator {
    private const val SEPARATOR = "|"

    fun generate(vararg delimiters: String): Regex = delimiters.joinToString(SEPARATOR).toRegex()
}
