package stringcalculator.domain

class ParserSeparators private constructor(parserSeparators: MutableList<ParserSeparator>) {
    var separators = parserSeparators
        private set
        get() = field.toMutableList()

    fun getSize(): Int {
        return separators.size
    }

    fun getSeparatorsString(): List<String> {
        return separators.map { it.string }
    }

    companion object {
        private val DEFAULT_LIST_FOR_STRING_EXPRESSION: MutableList<ParserSeparator> = mutableListOf(
            ParserSeparator(":"), ParserSeparator(",")
        )

        fun toEmpty(): ParserSeparators {
            return ParserSeparators(mutableListOf())
        }

        fun ofStringExpression(): ParserSeparators {
            return ParserSeparators(DEFAULT_LIST_FOR_STRING_EXPRESSION)
        }
    }
}
