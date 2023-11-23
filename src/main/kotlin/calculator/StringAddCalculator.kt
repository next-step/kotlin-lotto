package calculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty() || text.isBlank()) return 0

        val (customDelimiter, tokens) = parseCustomerDelimiterAndTokens(text)
        val numbers = parseNumbers(tokens, customDelimiter)
        checkOnlyPositiveNumber(numbers)

        return numbers.sum()
    }

    private fun parseCustomerDelimiterAndTokens(text: String) = Regex("(//(.)\n)?(.*)").find(text)?.let {
        if (it.groupValues.size == 2) {
            return Pair("", it.groupValues[0])
        }
        Pair(it.groupValues[2], it.groupValues[3])
    } ?: throw RuntimeException()

    private fun parseNumbers(tokens: String, customDelimiter: String) =
        tokens.split("[,:$customDelimiter]".toRegex()).map { number -> number.toInt() }

    private fun checkOnlyPositiveNumber(numbers: List<Int>) {
        numbers.map { PositiveNumber(it) }
    }
}
