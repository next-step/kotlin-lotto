package calculator

class StringAddCalculatorInput(input: String) {

    private val values: String
    private val delimiters: String

    init {
        val (delimiters, values) = parse(input)
        this.values = values
        this.delimiters = delimiters
    }

    fun numbers(): List<PositiveNumber> {
        return values.split(delimiters.toRegex()).map { PositiveNumber(it) }
    }

    private fun parse(input: String): Pair<String, String> {
        val matchEntire: MatchResult? = CUSTOM_DELIMITER_PATTERN.matchEntire(input)
        return if (matchEntire == null) Pair(DEFAULT_DELIMITERS, input)
        else Pair(matchEntire.groupValues[1], matchEntire.groupValues[2])
    }

    companion object {
        private const val DEFAULT_DELIMITERS = "[,:]"
        private val CUSTOM_DELIMITER_PATTERN = Regex("//(.)\n(.*)")
    }
}
