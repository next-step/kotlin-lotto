package calculator.domain

class Separators(private val separators: MutableList<Char> = DEFAULT_SEPARATORS) {
    val value: List<Char>
        get() = separators

    fun separate(input: String): List<String> {
        return regexExpression.find(input)?.let {
            add(it.groupValues[FIRST_STRING_INDEX][0])
            it.groupValues[SECOND_STRING_INDEX].split(this.toRegex())
        } ?: input.split(this.toRegex())
    }

    private fun add(separator: Char) {
        validate(separator)
        separators.add(separator)
    }

    private fun toRegex(): Regex {
        return separators.joinToString(VERTICAL_BAR).toRegex()
    }

    private fun validate(value: Char) {
        if (Character.getNumericValue(value) != INVALID_RESULT_NUMBER) {
            throw IllegalArgumentException(ERROR_MESSAGE)
        }
    }

    companion object {
        private const val INVALID_RESULT_NUMBER = -1
        private const val COMMA = ','
        private const val COLON = ':'
        private const val VERTICAL_BAR = "|"
        private val DEFAULT_SEPARATORS = mutableListOf(COMMA, COLON)
        private const val FIRST_STRING_INDEX = 1
        private const val SECOND_STRING_INDEX = 2
        private const val DEFAULT_SEPARATOR_FIND_REGEX = "//(.)\n(.*)"
        private val regexExpression = Regex(DEFAULT_SEPARATOR_FIND_REGEX)

        private const val ERROR_MESSAGE = "숫자는 구분자가 될 수 없습니다."
    }
}
