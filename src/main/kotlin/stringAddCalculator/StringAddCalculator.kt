package stringAddCalculator

import stringAddCalculator.customDelimiter.CustomDelimiter
import stringAddCalculator.number.PositiveNumber

class StringAddCalculator(
    private var expression: String,
    private var customDelimiters: List<CustomDelimiter> = emptyList(),
    private var delimiters: List<String> = listOf(DELIMITER_COMMA, DELIMITER_COLON),
) {
    private lateinit var numbers: List<PositiveNumber>

    init {
        executeCustomDelimiterParse()
        initNumbers()
    }

    fun calculate(): Int {
        return numbers.map { it.value }.reduce { acc, n -> acc + n }
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
        val numbers = expression.split(delimiterStr.toRegex()).map { number -> PositiveNumber(number.toInt()) }
        this.numbers = numbers
    }

    companion object {
        const val DELIMITER_COMMA = ","
        const val DELIMITER_COLON = ":"
    }
}
