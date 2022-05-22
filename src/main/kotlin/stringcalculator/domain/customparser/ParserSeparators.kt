package stringcalculator.domain.customparser

class ParserSeparators(parserSeparators: List<ParserSeparator>) {
    val separators: List<ParserSeparator> = parserSeparators
    val separatorsString: List<String>
        get() = separators.map { it.string }
    val size: Int
        get() = separators.size
}
