package stringcalculator

object StringAddCalculator {

    fun calculate(input: String?): Int {
        if (input.isNullOrEmpty()) return Constants.ZERO
        val numbers = Numbers(
            this.splitDelimiter(input)
                .map { Number(it.toInt()) }
        )
        return numbers.sum().value
    }

    private fun splitDelimiter(input: String): List<String> {
        val result = Regex(Constants.CUSTOM_DELIMITER_REGEX).find(input)
        result?.let {
            val (delimiter, value) = it.destructured
            return value.split(delimiter)
        }
        return input.split(Constants.DELIMITER_REGEX.toRegex())
    }
}
