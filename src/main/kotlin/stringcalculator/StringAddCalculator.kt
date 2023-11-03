package stringcalculator

object StringAddCalculator {
    private const val ZERO = 0

    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) return ZERO

        val (delimiter, numbersText) = StringParser.findCustomDelimiterAndNumbers(text)
        val numbers = StringParser.splitByDelimiter(numbersText, delimiter)
        return sum(numbers)
    }

    private fun sum(numbers: List<String>): Int {
        return numbers.sumOf {
            val number = it.toInt()
            require(number >= 0) { "Negative number not allowed: $number" }
            number
        }
    }
}
