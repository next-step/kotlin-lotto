package stringcalculator.core

object FormulaParser {
    private const val REGEX_FIND_CUSTOM_DELIMITER = "(?<=//)(.*?)(?=\n)"
    private val DELIMITER_FIND_PATTERN = Regex(REGEX_FIND_CUSTOM_DELIMITER)

    fun parse(str: String?): List<Number> {
        if (str.isNullOrBlank()) {
            return listOf(Number.ZERO)
        }

        val strings = makeSplitter(str).split()

        return strings.map(::Number)
    }

    private fun makeSplitter(str: String): StringSplitter {
        if (str.length < 4) {
            return StringSplitter(str)
        }
        val delimiter = extractCustomDelimiter(str)
        if (delimiter.isNullOrBlank()) {
            return StringSplitter(str)
        }
        return StringSplitter(str.substring(4), delimiter)
    }

    private fun extractCustomDelimiter(str: String): String? {
        val matchResult = DELIMITER_FIND_PATTERN.find(str)
        return matchResult?.value
    }
}
