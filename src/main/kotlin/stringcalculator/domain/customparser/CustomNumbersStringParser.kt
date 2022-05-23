package stringcalculator.domain.customparser

class CustomNumbersStringParser(stringExpression: String, separators: ParserSeparators) {
    private val customNumberExpression: CustomNumberExpression
    val parsedPositiveNumbers: List<PositiveNumber>

    init {
        customNumberExpression = CustomNumberExpression(stringExpression, separators)
        parsedPositiveNumbers = splitBySeparators(customNumberExpression.string, separators).map { PositiveNumber(it) }
    }

    private fun splitBySeparators(
        stringExpression: String,
        separators: ParserSeparators
    ) = stringExpression.split(Regex(separators.separatorsString.toString())).map { it.toInt() }
}
