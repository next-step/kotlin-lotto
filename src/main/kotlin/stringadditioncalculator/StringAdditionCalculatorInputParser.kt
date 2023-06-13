package stringadditioncalculator

class StringAdditionCalculatorInputParser {

    fun parse(input: String?): List<String> {
        if (input.isNullOrBlank()) {
            return emptyList()
        }

        return if (hasCustomDelimiter(input)) parseByCustomDelimiter(input) else input.split(delimiters = DEFAULT_DELIMITERS)
    }

    private fun hasCustomDelimiter(input: String): Boolean = Regex(CUSTOM_DELIMITER_INPUT).matches(input)

    private fun parseByCustomDelimiter(input: String): List<String> = Regex(CUSTOM_DELIMITER_INPUT).find(input)?.let {
        val customDelimiter = it.groupValues[1]
        it.groupValues[2].split(delimiters = DEFAULT_DELIMITERS.plus(customDelimiter))
    } ?: emptyList()

    companion object {
        val DEFAULT_DELIMITERS = arrayOf(",", ";")
        const val CUSTOM_DELIMITER_INPUT = """\/\/(.)\\n(.*)"""
    }
}
