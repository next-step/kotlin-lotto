package calculator.domain

private const val DELIMITER = ",|:"
private const val CUSTOM_DELIMITER_INDICATOR = "//(.)\n(.*)"

class InputParser {
    fun parseWithDelimiter(input: String?): Array<Int> {
        if (input.isNullOrEmpty()) {
            return arrayOf(0)
        }
        if (input.startsWith("//")) {
            val (customDelimiter, tokens) = CUSTOM_DELIMITER_INDICATOR.toRegex().find(input)!!.destructured
            return tokens.split(customDelimiter).map { it.toInt() }.toTypedArray()
        }
        return input.split(DELIMITER.toRegex()).map { it.toInt() }.toTypedArray()
    }
}
