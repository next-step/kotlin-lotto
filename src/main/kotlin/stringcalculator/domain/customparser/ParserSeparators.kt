package stringcalculator.domain.customparser

class ParserSeparators private constructor(parserSeparators: MutableList<ParserSeparator>) {
    private var _separators = parserSeparators
    var separators: MutableList<ParserSeparator> = _separators
        private set
        get() = _separators.toMutableList()

    fun add(separator: ParserSeparator) {
        _separators.add(separator)
    }

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
            return ParserSeparators(DEFAULT_LIST_FOR_STRING_EXPRESSION.toMutableList())
        }
    }
}
