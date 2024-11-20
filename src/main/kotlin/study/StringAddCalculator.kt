package study

object StringAddCalculator {
    private const val DEFAULT_DELIMITERS = "[,:]"

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return PositiveNumber.ZERO.value
        }

        return parseString(text)
            .filter { it.isNotBlank() }
            .map { PositiveNumber(it) }
            .sumOf { it.value }
    }

    private fun parseString(text: String): List<String> {
        if (CustomDelimiter.isCustomDelimiter(text)) {
            return CustomDelimiter.parse(text)
        }

        return text.split(DEFAULT_DELIMITERS.toRegex())
    }
}
