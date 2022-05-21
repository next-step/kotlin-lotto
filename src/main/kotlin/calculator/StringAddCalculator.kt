package calculator

class StringAddCalculator {
    fun add(text: String?): Int =
        if (text.isNullOrBlank()) 0
        else
            sumBy(getNumberInput(text), getDelimiter(text))

    private fun sumBy(numberInput: String, delimiter: Regex): Int =
        numberInput
            .split(delimiter)
            .sumOf { it.toPositiveOrThrow() }

    private fun getNumberInput(text: String): String =
        INPUT_NUMBER_REGEX.find(text)
            ?.getMatched()
            ?: text

    private fun getDelimiter(text: String): Regex =
        DELIMITER_REGEX.find(text)
            ?.getMatched()
            ?.toRegex()
            ?: DEFAULT_DELIMITER_REGEX

    private fun MatchResult.getMatched(): String = this.groupValues[MATCHED_GROUP_INDEX]

    private fun String.toPositiveOrThrow(): Int =
        toInt()
            .takeIf { it >= 0 }
            ?: throw RuntimeException("Negative number is not allowed")

    companion object {
        private val INPUT_NUMBER_REGEX = Regex("//.\n(.*)")
        private val DELIMITER_REGEX = Regex("//(.)\n")
        private val DEFAULT_DELIMITER_REGEX = Regex("[,|:]")
        private const val MATCHED_GROUP_INDEX = 1
    }
}
