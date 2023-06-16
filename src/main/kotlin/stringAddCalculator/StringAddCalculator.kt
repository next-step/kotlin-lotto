package stringAddCalculator

import stringAddCalculator.customDelimiter.CustomDelimiter
import java.lang.RuntimeException

class StringAddCalculator(
    private var expression: String,
    private var customDelimiters: List<CustomDelimiter> = emptyList(),
    private var delimiters: List<String> = listOf(DELIMITER_COMMA, DELIMITER_COLON),
) {
    private lateinit var numbers: List<Int>

    init {
        executeCustomDelimiterParse()
        initNumbers()
    }

    fun calculate(): Int {
        return numbers.reduce { acc, c -> acc + c }
    }

    private fun executeCustomDelimiterParse() {
        customDelimiters.forEach { customDelimiter ->
            val parserResult = customDelimiter.parse(expression)
            parserResult?.let {
                delimiters = delimiters.plus(it.customDelimiter)
                expression = it.expression
            }
        }
    }

    private fun initNumbers() {
        val delimiterStr = delimiters.reduce { acc, s -> "$acc|$s" }
        val numbers = runCatching {
            expression.split(delimiterStr.toRegex()).map { number -> number.toInt() }
        }.onFailure { throw RuntimeException(CalcErrorCode.INVALID_NUMBER.msg) }
            .getOrDefault(emptyList())

        if (numbers.any { Integer.signum(it) != POSITIVE_NUMBER_RESULT }) throw RuntimeException(CalcErrorCode.INVALID_NUMBER.msg)
        this.numbers = numbers
    }

    companion object {
        const val DELIMITER_COMMA = ","
        const val DELIMITER_COLON = ":"
        const val POSITIVE_NUMBER_RESULT = 1
    }
}
