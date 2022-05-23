package stringcalculator.domain.customparser

class CustomExpressionParser(private val expression: String, defaultSeparators: ParserSeparators) {
    private val stringNumberParser: CustomNumbersStringParser
    private val separators: ParserSeparators
    val parsedNumber: List<Int>
        get() = stringNumberParser.parsedPositiveNumbers.map { it.value }

    init {
        val paramSeparators: MutableList<ParserSeparator> = mutableListOf()
        paramSeparators.addAll(defaultSeparators.separators)

        if (hasCustomSeparatorString()) {
            val customSeparatorParser = CustomSeparatorParser(getCustomExpressionString())
            paramSeparators.add(customSeparatorParser.parserSeparator)
        }

        separators = ParserSeparators(paramSeparators)
        stringNumberParser = CustomNumbersStringParser(getNumbersExpressionString(), separators)
    }

    private fun getNumbersExpressionString(): String {
        if (hasCustomSeparatorString()) {
            return expression.substring(CustomSeparatorParser.findEndIndexForSubstring(expression))
        }
        return expression
    }

    private fun getCustomExpressionString(): String {
        return expression.substring(0, CustomSeparatorParser.findEndIndexForSubstring(expression))
    }

    private fun hasCustomSeparatorString(): Boolean {
        return CustomSeparatorParser.findEndIndexForSubstring(expression) >= 0
    }
}
