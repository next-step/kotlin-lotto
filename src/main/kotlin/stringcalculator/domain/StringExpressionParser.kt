package stringcalculator.domain

class StringExpressionParser(expression: String) {
    private val stringNumberParser: StringNumberParser
    private val separators: ParserSeparators = ParserSeparators.ofStringExpression()

    fun getParsedNumber(): List<Number> {
        return stringNumberParser.parsedNumbers
    }

    init {
        var numberExpression: String = expression
        if (hasCustomSeparatorString(expression)) {
            val stringCustomSeparatorParser = StringCustomSeparatorParser(
                expression.substring(0, StringCustomSeparatorParser.findEndIndexForSubstring(expression))
            )
            separators.add(stringCustomSeparatorParser.parserSeparator)
            numberExpression =
                numberExpression.substring(StringCustomSeparatorParser.findEndIndexForSubstring(expression))
        }

        stringNumberParser = StringNumberParser(numberExpression, separators)
    }

    companion object {
        fun hasCustomSeparatorString(expression: String): Boolean {
            return StringCustomSeparatorParser.findEndIndexForSubstring(expression) >= 0
        }
    }
}
