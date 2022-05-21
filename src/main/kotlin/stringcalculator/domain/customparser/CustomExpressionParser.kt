package stringcalculator.domain.customparser

class CustomExpressionParser(expression: String) {
    private val stringNumberParser: CustomNumbersStringParser
    private val separators: ParserSeparators = ParserSeparators.ofStringExpression()

    fun getParsedNumber(): List<Int> {
        return stringNumberParser.parsedNumbers
    }

    init {
        var numberExpression: String = expression
        if (hasCustomSeparatorString(expression)) {
            val customSeparatorParser = CustomSeparatorParser(
                expression.substring(0, CustomSeparatorParser.findEndIndexForSubstring(expression))
            )
            separators.add(customSeparatorParser.parserSeparator)
            numberExpression =
                numberExpression.substring(CustomSeparatorParser.findEndIndexForSubstring(expression))
        }

        stringNumberParser = CustomNumbersStringParser(numberExpression, separators)
    }

    companion object {
        fun hasCustomSeparatorString(expression: String): Boolean {
            return CustomSeparatorParser.findEndIndexForSubstring(expression) >= 0
        }
    }
}
