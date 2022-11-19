package domain

class Calculator {
    private var numbers = Numbers()
    private val separators = Separators()

    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) return 0
        val tokens = getTokens(input)
        numbers = Numbers.from(tokens)
        return numbers.sum()
    }

    private fun getTokens(input: String): List<String> {
        return Regex(DEFAULT_SEPARATOR_FIND_REGEX).find(input)?.let {
            addCustomSeparator(it.groupValues[1])
            it.groupValues[2].split(separators.toRegex())
        } ?: input.split(separators.toRegex())
    }

    private fun addCustomSeparator(separator: String) {
        separators.add(separator[0])
    }

    companion object {
        private const val DEFAULT_SEPARATOR_FIND_REGEX = "//(.)\n(.*)"
    }
}
