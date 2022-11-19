package domain

class Calculator {
    private var numbers = Numbers()
    private val separators = Separators()
    private val regexExpression = Regex(DEFAULT_SEPARATOR_FIND_REGEX)

    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) return ZERO
        val tokens = getTokens(input)
        numbers = Numbers.from(tokens)
        return numbers.sum()
    }

    private fun getTokens(input: String): List<String> {
        return regexExpression.find(input)?.let {
            addCustomSeparator(it.groupValues[FIRST_STRING_INDEX])
            it.groupValues[SECOND_STRING_INDEX].split(separators.toRegex())
        } ?: input.split(separators.toRegex())
    }

    private fun addCustomSeparator(separator: String) {
        separators.add(separator[0])
    }

    companion object {
        private const val ZERO = 0
        private const val FIRST_STRING_INDEX = 1
        private const val SECOND_STRING_INDEX = 1
        private const val DEFAULT_SEPARATOR_FIND_REGEX = "//(.)\n(.*)"
    }
}
