package stringadditioncalculator

object StringAdditionCalculatorInputParser {

    private val DEFAULT_DELIMITERS = arrayOf(",", ";")
    private const val CUSTOM_DELIMITER_INPUT = """\/\/(.)\\n(.*)"""
    private const val INVALID_CUSTOM_DELIMITER = "-"

    fun parse(input: String?): StringNumbers {
        if (input.isNullOrBlank()) {
            return StringNumbers(emptyList())
        }

        val stringNumbers =
            if (hasCustomDelimiter(input)) parseByCustomDelimiter(input) else input.split(delimiters = DEFAULT_DELIMITERS)

        return StringNumbers(stringNumbers)
    }

    private fun hasCustomDelimiter(input: String): Boolean = Regex(CUSTOM_DELIMITER_INPUT).matches(input)

    private fun parseByCustomDelimiter(input: String): List<String> = Regex(CUSTOM_DELIMITER_INPUT).find(input)?.let {
        require(it.groupValues[1] != INVALID_CUSTOM_DELIMITER) {
            "Invalid custom delimiter : $INVALID_CUSTOM_DELIMITER"
        }
        val customDelimiter = it.groupValues[1]
        it.groupValues[2].split(delimiters = DEFAULT_DELIMITERS.plus(customDelimiter))
    } ?: emptyList()
}
