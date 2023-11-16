package calculator

object StringAddCalculatorParser {
    private val DEFAULT_DELIMITER_REGEX = "[,|:]".toRegex()
    private val CUSTOM_DELIMITER_REGEX: Regex = "//(.)\n(.*)".toRegex()

    fun parse(text: String?): List<StringAddCalculatorNumber> {
        if (text.isNullOrBlank()) { return emptyList() }
        if (isNumber(text)) { return listOf(StringAddCalculatorNumber.of(text)) }

        CUSTOM_DELIMITER_REGEX.find(text)?.let {
            val (delimiter, numbers) = it.destructured
            return numbers.split(delimiter).map { number -> StringAddCalculatorNumber.of(number) }
        }

        return text.split(DEFAULT_DELIMITER_REGEX).map { StringAddCalculatorNumber.of(it) }
    }

    private fun isNumber(text: String): Boolean {
        text.toIntOrNull()?.let { return true } ?: return false
    }
}
