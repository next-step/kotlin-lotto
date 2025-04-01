package calculator

object StringAdditionCalculator {
    private const val CUSTOM_DELIMITER_PATTERN = "^//(.)\n(.*)"

    private val delimiters = arrayOf(",", ":")

    fun add(input: String?): Int {
        if (input.isNullOrBlank()) return 0
        return addNumbers(input)
    }

    private fun addNumbers(input: String): Int =
        input
            .splitWithCustomDelimiter()
            .sumOf { parseNumber(it) }

    private fun parseNumber(input: String): Int {
        val number = input.toIntOrNull() ?: throw RuntimeException("input should contain only numbers but has $input")
        if (number < 0) throw RuntimeException("Number should not be negative but was $number")
        return number
    }

    private fun String.splitWithCustomDelimiter(): List<String> {
        val result = Regex(CUSTOM_DELIMITER_PATTERN).find(this) ?: return this.split(*delimiters)

        val customDelimiter = result.groupValues[1]
        val inputAfterCustomDelimiter = result.groupValues[2]
        return inputAfterCustomDelimiter.split(customDelimiter, *delimiters)
    }
}
