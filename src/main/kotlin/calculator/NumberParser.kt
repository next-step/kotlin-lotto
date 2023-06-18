package calculator

class NumberParser(input: String) {

    val numbers: List<PositiveNumber>

    init {
        this.numbers = parse(input).map { PositiveNumber(it) }
    }

    private fun parse(input: String): List<String> {
        val matchEntire: MatchResult? = CUSTOM_DELIMITER_PATTERN.matchEntire(input)
        return if (matchEntire == null) input.split(DEFAULT_DELIMITERS)
        else matchEntire.groupValues[2].split(matchEntire.groupValues[1])
    }

    companion object {
        private val DEFAULT_DELIMITERS = Regex("[,:]")
        private val CUSTOM_DELIMITER_PATTERN = Regex("//(.)\n(.*)")
    }
}
