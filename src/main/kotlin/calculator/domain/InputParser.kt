package calculator.domain

object InputParser {
    private const val DEFAULT_DELIMITER_INDICATOR = ",|:"
    private const val CUSTOM_DELIMITER_INDICATOR = "//(.)\n(.*)"

    fun parseWithDelimiter(input: String?): Array<Int> {
        if (input.isNullOrEmpty()) {
            return arrayOf(0)
        }
        try {
            return parse(input)
        } catch (e: NumberFormatException) {
            throw RuntimeException("숫자 이외의 값은 입력할 수 없습니다.")
        }
    }

    private fun parse(input: String): Array<Int> {
        if (input.startsWith("//")) {
            return parseWithCustomDelimiter(input)
        }
        return parseWithDefaultDelimiter(input)
    }

    private fun parseWithCustomDelimiter(input: String): Array<Int> {
        val findResult = CUSTOM_DELIMITER_INDICATOR.toRegex().find(input)
        if (findResult != null) {
            val (customDelimiter, tokens) = findResult.destructured
            return tokens.split(customDelimiter).map { it.toInt() }.toTypedArray()
        }
        return arrayOf(0)
    }

    private fun parseWithDefaultDelimiter(input: String) =
        input.split(DEFAULT_DELIMITER_INDICATOR.toRegex()).map { it.toInt() }.toTypedArray()
}
