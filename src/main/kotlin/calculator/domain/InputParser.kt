package calculator.domain

private const val DEFAULT_DELIMITER_INDICATOR = ",|:"
private const val CUSTOM_DELIMITER_INDICATOR = "//(.)\n(.*)"

class InputParser {
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
            val (customDelimiter, tokens) = CUSTOM_DELIMITER_INDICATOR.toRegex().find(input)!!.destructured
            return tokens.split(customDelimiter).map { it.toInt() }.toTypedArray()
        }
        return input.split(DEFAULT_DELIMITER_INDICATOR.toRegex()).map { it.toInt() }.toTypedArray()
    }
}
