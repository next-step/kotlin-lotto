package stringcalculator.domain

class ParserSeparators private constructor(parserSeparators: MutableList<ParserSeparator>) {
    var separators = parserSeparators
        private set

    companion object {
        private val DEFAULT_LIST_FOR_STRING_EXPRESSION: MutableList<ParserSeparator> = mutableListOf(
            ParserSeparator(":"), ParserSeparator(",")
        )

        fun ofStringExpression(): ParserSeparators {
            return ParserSeparators(DEFAULT_LIST_FOR_STRING_EXPRESSION)
        }
    }
}
