package calculator

object StringAddCalculatorParser {
    private val DEFAULT_DELIMITER_REGEX = "[,|:]".toRegex()
    private val CUSTOM_DELIMITER_REGEX: Regex = "//(.)\n(.*)".toRegex()

    fun parse(text: String?): List<StringAddCalculatorElement> {
        if (text.isNullOrBlank()) { return emptyList() }
        if (isNumber(text)) { return listOf(StringAddCalculatorElement.of(text)) }

        CUSTOM_DELIMITER_REGEX.find(text)?.let {
            val (delimiter, numbers) = it.destructured
            return numbers.split(delimiter).map { number -> StringAddCalculatorElement.of(number) }
        }

        return text.split(DEFAULT_DELIMITER_REGEX).map { number -> StringAddCalculatorElement.of(number) }
    }

    private fun isNumber(text: String): Boolean {
        return try {
            text.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }
}
