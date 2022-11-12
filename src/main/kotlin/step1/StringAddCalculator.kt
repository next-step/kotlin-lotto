package step1

class StringAddCalculator(
    vararg delimiter: String = DEFAULT_DELIMITERS
) {
    companion object {
        val DEFAULT_DELIMITERS = arrayOf(",", ":")
        const val REGEX_DELIMITER = "|"
        const val REGEX_PREFIX = "("
        const val REGEX_POSTFIX = ")"
    }

    private val delimiterList: List<String>
    private val delimiterRegex: Regex

    init {
        delimiterList = listOf(*delimiter)
        delimiterRegex = Regex(delimiterList.joinToString(REGEX_DELIMITER, REGEX_PREFIX, REGEX_POSTFIX))
    }

    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) {
            return 0
        }

        val inputNumberList = input.trim().split(delimiterRegex).asSequence().map { it.toInt() }

        return inputNumberList.sum()
    }
}
