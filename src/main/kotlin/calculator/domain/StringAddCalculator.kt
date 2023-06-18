package calculator.domain

object StringAddCalculator {
    private const val DEFAULT_VALUE = 0

    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) return DEFAULT_VALUE

        return StringCalculatorParser.getPositiveNumbers(input).sum()
    }
}

internal object StringCalculatorParser {
    private const val CUSTOM_DELIMITER_PREFIX = "//"
    private const val CUSTOM_DELIMITER_POSTFIX = "\n"
    private val DEFAULT_DELIMITER_REGEX = Regex("[,:]")
    private val CUSTOM_DELIMITER_PARSING_REGEX = Regex("$CUSTOM_DELIMITER_PREFIX(.)$CUSTOM_DELIMITER_POSTFIX(.*)")

    fun getPositiveNumbers(input: String): List<Int> {
        val (operand, delimiters) = partitionByOperandAndDelimiter(input)

        return operand.split(delimiters).map { it.toPositiveNumber() }
    }

    private fun partitionByOperandAndDelimiter(input: String): Pair<String, Regex> {
        if (input.hasCustomDelimiter()) {
            val matchResult = requireNotNull(CUSTOM_DELIMITER_PARSING_REGEX.find(input)) { "커스텀 구분자가 잘못되었습니다." }

            return matchResult.groupValues[2] to matchResult.groupValues[1].toRegex()
        }

        return input to DEFAULT_DELIMITER_REGEX
    }

    private fun String.hasCustomDelimiter(): Boolean {
        return this.startsWith(CUSTOM_DELIMITER_PREFIX)
    }

    private fun String.canParseAsNumber(): Boolean {
        return this.toIntOrNull() != null
    }

    private fun String.toPositiveNumber(): Int {
        require(this.canParseAsNumber()) { "숫자 이외의 값이 전달되었습니다." }

        return this.toInt().also { require(it >= 0) { "음수는 전달할 수 없습니다." } }
    }
}
