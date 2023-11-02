package stringcalculator

object StringAddCalculator {

    private const val ZERO = 0
    private const val DELIMITER_REGEX = "[,:]"
    private const val CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)"

    fun calculate(input: String?): Int {
        if (input.isNullOrEmpty()) return ZERO
        val numbers = Numbers(
            this.splitDelimiter(input)
                .map { Number(it.toInt()) }
        )
        return numbers.sum().value
    }

    private fun splitDelimiter(input: String): List<String> {
        val result = Regex(CUSTOM_DELIMITER_REGEX).find(input)
        result?.let {
            val (delimiter, value) = it.destructured
            return value.split(delimiter)
        }
        return input.split(DELIMITER_REGEX.toRegex())
    }
}
