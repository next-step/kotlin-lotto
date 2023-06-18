package calculator

class DefaultDelimiterStrategy : DelimiterStrategy {
    override fun parse(input: String): List<Int>? =
        Regex(DEFAULT_DELIMITERS).find(input)?.let {
            parseByDefaultDelimiter(input)
        }

    private fun parseByDefaultDelimiter(input: String): List<Int> =
        input.split(DEFAULT_DELIMITERS.toRegex())
            .map { it.toInt() }

    companion object {
        private const val DEFAULT_DELIMITERS = "[,:]"
    }
}
