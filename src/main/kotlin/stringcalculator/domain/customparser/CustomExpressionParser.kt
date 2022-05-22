package stringcalculator.domain.customparser

class CustomExpressionParser(private val expression: String) {
    private val stringNumberParser: CustomNumbersStringParser
    private val separators: ParserSeparators = ParserSeparators.ofStringExpression()
    val parsedNumber: List<Int>
        get() = stringNumberParser.parsedNumbers

    init {
        initCustomSeparator()
        stringNumberParser = CustomNumbersStringParser(getNumbersExpressionString(), separators)
    }

    private fun initCustomSeparator() {
        if (hasCustomSeparatorString()) {
            val customSeparatorParser = CustomSeparatorParser(getCustomExpressionString())
            separators.add(customSeparatorParser.parserSeparator)
        }
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
