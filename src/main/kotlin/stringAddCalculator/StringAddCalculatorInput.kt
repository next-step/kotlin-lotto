package stringAddCalculator

class StringAddCalculatorInput(private val input: String) {
    fun parse(): List<Int> {
        if (input.isEmpty()) {
            return listOf()
        }

        val customDelimiter = getCustomDelimiter()

        return getIntegerPart().split(Regex("[${DEFAULT_DELIMITERS.joinToString()}$customDelimiter]"))
            .map { it.toInt() }
    }

    private fun getCustomDelimiter(): String {
        val result = Regex("//(.)\n(.*)").find(input) ?: return ""

        return result.groupValues[1]
    }

    private fun getIntegerPart() = input.split("\n").last()

    companion object {
        val DEFAULT_DELIMITERS = listOf(",", ":")
    }
}
