package stringcalculator.core

object FormulaParser {
    private val DELIMITER_FIND_PATTERN = Regex("(?<=//)(.*?)(?=\n)")
    private val CUSTOM_DELIMITER_DECLARE_LEN = 4;

    fun parse(str: String?): List<Number> {
        if (str.isNullOrBlank()) {
            return listOf(Number.ZERO)
        }

        val strings = makeSplitter(str).split()

        return strings.map(::Number)
    }

    private fun makeSplitter(str: String): StringSplitter {
        if (str.length < CUSTOM_DELIMITER_DECLARE_LEN) {
            return StringSplitter(str)
        }
        val delimiter = extractCustomDelimiter(str)
        if (delimiter.isNullOrBlank()) {
            return StringSplitter(str)
        }
        return StringSplitter(str.substring(CUSTOM_DELIMITER_DECLARE_LEN), delimiter)
    }

    private fun extractCustomDelimiter(str: String): String? {
        val matchResult = DELIMITER_FIND_PATTERN.find(str)
        return matchResult?.value
    }
}
