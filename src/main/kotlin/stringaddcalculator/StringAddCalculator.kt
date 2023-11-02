package stringaddcalculator

class StringAddCalculator {
    fun calculate(input: String?): Int {
        val validInput = input.takeUnless { it.isNullOrBlank() } ?: return 0
        NEGATIVE_NUMBER_REGEX.takeIf { it.containsMatchIn(validInput) }?.let { throw RuntimeException() }
        val numbers: List<Int> = getIntegersFromInput(validInput)
        return numbers.sum()
    }

    private fun getIntegersFromInput(input: String): List<Int> =
        if (input.contains(CUSTOM_DELIMITER_REGEX)) {
            val matchResult = CUSTOM_DELIMITER_REGEX.matchEntire(input)
            val (delimiter, numbers) = matchResult?.destructured ?: throw IllegalArgumentException()
            numbers.split(delimiter).map { it.toInt() }
        } else {
            input.split(*DEFAULT_DELIMITERS).map { it.toInt() }
        }

    companion object {
        private val NEGATIVE_NUMBER_REGEX = "-\\d+".toRegex()
        private val CUSTOM_DELIMITER_REGEX: Regex = "//(.)\\n(.+)".toRegex()
        private val DEFAULT_DELIMITERS = arrayOf(",", ":")
    }
}
