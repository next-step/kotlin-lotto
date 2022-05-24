package stringcalculator.domain.customparser

class ParserSeparators(parserSeparators: List<ParserSeparator>) {
    val separators: List<ParserSeparator> = parserSeparators
    val separatorsString: List<String>
        get() = separators.map { it.string }
    val size: Int
        get() = separators.size

    init {
        validateSeparatorsEmpty(separators)
    }

    companion object {
        private const val ERROR_MESSAGE_SEPARATOR_ZERO = "숫자를 추출하기 위한 구분자가 없습니다"
        private fun validateSeparatorsEmpty(separators: List<ParserSeparator>) {
            require(separators.isNotEmpty()) { ERROR_MESSAGE_SEPARATOR_ZERO }
        }
    }
}
