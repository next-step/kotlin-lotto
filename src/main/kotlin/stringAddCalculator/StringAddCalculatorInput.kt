package stringAddCalculator

class StringAddCalculatorInput(private val input: String) {
    fun parse(): List<Int> {
        val customDelimiter = getCustomDelimiter()

        return getIntegerPart().split(Regex("[${DEFAULT_DELIMITERS.joinToString()}$customDelimiter]"))
            .map {
                try {
                    convertToInt(it)
                } catch (e: NumberFormatException) {
                    throw RuntimeException()
                }
            }
    }

    private fun getCustomDelimiter(): String {
        val result = Regex("//(.)\n(.*)").find(input) ?: return ""

        return result.groupValues[1]
    }

    private fun getIntegerPart(): String = input.split("\n").last()

    private fun convertToInt(text: String): Int = text.toIntOrNull()
        ?.takeIf { it >= MIN_NUMBER }
        ?: throw RuntimeException()

    companion object {
        private val DEFAULT_DELIMITERS = listOf(",", ":")
        private const val MIN_NUMBER = 0
    }
}
