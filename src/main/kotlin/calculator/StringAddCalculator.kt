package calculator

class StringAddCalculator {
    private val delimiters = mutableListOf(",", ":")

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) return 0

        setCustomDelimiter(text)

        val numbers = tokenize(getNumberPart(text))

        validate(numbers)

        return numbers.reduce { a, b -> a + b }
    }

    private fun setCustomDelimiter(text: String) {
        val delimiter = text
            .substringAfter(CUSTOM_DELEMETER_HEADER, "")
            .substringBefore(SECTION_DELEMETER, "")

        if (delimiter.isNotBlank()) {
            delimiters.add(delimiter)
        }
    }

    private fun getNumberPart(text: String): String {
        return text.substringAfter(SECTION_DELEMETER)
    }

    private fun tokenize(text: String): List<Int> {
        return text
            .split(*delimiters.toTypedArray())
            .map { it.toInt() }
    }

    private fun validate(numbers: List<Int>) {
        numbers.forEach { require(it > 0) }
    }

    companion object {
        const val SECTION_DELEMETER = "\n"
        const val CUSTOM_DELEMETER_HEADER = "//"
    }
}
