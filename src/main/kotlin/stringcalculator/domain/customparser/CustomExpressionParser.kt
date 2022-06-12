package stringcalculator.domain.customparser

class CustomExpressionParser(private val expression: String, defaultSeparators: ParserSeparators) {
    private val stringNumberParser: CustomNumbersStringParser
    private val separators: ParserSeparators
    val parsedNumber: List<Int>
        get() = stringNumberParser.parsedPositiveNumbers.map { it.value }

    init {
        val paramSeparators: MutableList<ParserSeparator> = mutableListOf()
        paramSeparators.addAll(defaultSeparators.separators)

        getCustomExpressionString()?.let {
            paramSeparators.add(CustomSeparatorParser(it).parserSeparator)
        }

        separators = ParserSeparators(paramSeparators)
        stringNumberParser = CustomNumbersStringParser(getNumbersExpressionString(), separators)
    }

    private fun getCustomExpressionString(): String? {
        val matchResult = CustomSeparatorParser.REGEX_CUSTOM_SEPARATOR_EXPRESSION.find(expression)
        return matchResult?.groups?.get(0)?.value
    }

    private fun getNumbersExpressionString(): String {
        return CustomSeparatorParser.REGEX_CUSTOM_SEPARATOR_EXPRESSION.replace(expression, "")
    }
}
