package domain

class Separators {
    private val separators: MutableList<Char> = DEFAULT_SEPARATORS

    fun get(): List<Char> {
        return separators
    }

    fun add(separator: Char) {
        validate(separator)
        separators.add(separator)
    }

    fun toRegex(): Regex {
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

        private const val ERROR_MESSAGE = "숫자는 구분자가 될 수 없습니다."
    }
}
