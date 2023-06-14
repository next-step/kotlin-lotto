package calculator.domain

object StringAdditionCalculator {
    private const val DEFAULT_VALUE = 0
    private const val CUSTOM_DELIMITER_PREFIX = "//"
    private const val CUSTOM_DELIMITER_POSTFIX = "\n"
    private val DEFAULT_DELIMITER_REGEX = Regex("[,:]")
    private val CUSTOM_DELIMITER_PARSING_REGEX = Regex("$CUSTOM_DELIMITER_PREFIX(.)$CUSTOM_DELIMITER_POSTFIX(.*)")

    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) return DEFAULT_VALUE

        val (operand, delimiters) = input.partitionByOperandAndDelimiter()
        val (numberTokens, notNumberTokens) = operand.split(delimiters).partition { it.canParseAsNumber() }
        val (positiveZeroNumberTokens, negativeNumberTokens) = numberTokens.partition { it.isPositiveZero() }

        if (notNumberTokens.isNotEmpty()) throw RuntimeException("숫자 이외의 값이 전달되었습니다.")
        if (negativeNumberTokens.isNotEmpty()) throw RuntimeException("음수는 전달할 수 없습니다.")

        return positiveZeroNumberTokens.sumOf { it.toInt() }
    }

    private fun String.partitionByOperandAndDelimiter(): Pair<String, Regex> {
        if (this.hasCustomDelimiter()) {
            val matchResult = requireNotNull(CUSTOM_DELIMITER_PARSING_REGEX.find(this)) { "커스텀 구분자가 잘못되었습니다." }

            return Pair(matchResult.groupValues[2], matchResult.groupValues[1].toRegex())
        }

        return Pair(this, DEFAULT_DELIMITER_REGEX)
    }

    private fun String.hasCustomDelimiter(): Boolean {
        return this.startsWith(CUSTOM_DELIMITER_PREFIX)
    }

    private fun String.canParseAsNumber(): Boolean {
        return this.toIntOrNull() != null
    }

    private fun String.isPositiveZero(): Boolean {
        return this.toInt() >= 0
    }
}
