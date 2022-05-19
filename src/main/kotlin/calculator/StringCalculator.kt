package calculator

class StringCalculator {

    fun add(input: String?): Int =
        if (input.isNullOrBlank()) {
            0
        } else {
            val numbers = getNumbers(input)
            checkNegativeNumber(numbers)
            numbers.sum()
        }

    private fun getNumbers(input: String): List<Int> =
        (getCustomDelimiterTokens(input) ?: getPredefinedDelimiterTokens(input)).map { it.toInt() }

    private fun getCustomDelimiterTokens(input: String): List<String>? =
        Regex("//(.)\n(.*)").find(input)?.let {
            it.groupValues[2].split(it.groupValues[1])
        }

    private fun getPredefinedDelimiterTokens(input: String): List<String> =
        input.split(',', ':')

    private fun checkNegativeNumber(numbers: List<Int>) {
        if (numbers.any { it < 0 }) throw RuntimeException()
    }
}
