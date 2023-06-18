package stringAddCalculator

import stringAddCalculator.customDelimiter.CustomDelimiter
import stringAddCalculator.number.PositiveNumber

class StringAddCalculator(
    _expression: String,
    private var customDelimiters: List<CustomDelimiter> = emptyList(),
    private var delimiters: List<String> = listOf(DELIMITER_COMMA, DELIMITER_COLON),
) {
    private val expression: String
    private lateinit var numbers: List<PositiveNumber>

    init {
        expression = executeCustomDelimiterParse(_expression)
        initNumbers()
    }

    fun calculate(): Int {
        return numbers.map { it.value }.reduce { acc, n -> acc + n }
    }

    private fun executeCustomDelimiterParse(initExpression: String): String {
        var _expression = initExpression
        customDelimiters.forEach { customDelimiter ->
            val parserResult = customDelimiter.parse(_expression)
            parserResult?.let {
                delimiters = delimiters.plus(it.customDelimiter)
                _expression = it.expression
            }
        }
        return _expression
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
