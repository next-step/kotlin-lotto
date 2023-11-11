package calculator

object StringAddCalculator {

    private const val EMPTY_RESULT = 0
    private const val CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)"
    private val DEFAULT_DELIMITER_REGEX = ",|:".toRegex()

    fun add(input: String?): Int {
        if (input.isNullOrEmpty()) return EMPTY_RESULT

        val numbers = splitInputByDelimiter(input)
        numbers.map { PositiveNumber(it) }

        return numbers.sum()
    }

    private fun splitInputByDelimiter(input: String): List<Int> {
        val findRegex = Regex(CUSTOM_SEPARATOR_REGEX).find(input)
        val split = findRegex?.let {
            val customDelimiter = it.groupValues[1]
            it.groupValues[2].split(customDelimiter)
        } ?: input.split(DEFAULT_DELIMITER_REGEX)

        return split.map { it.toInt() }
    }
}
