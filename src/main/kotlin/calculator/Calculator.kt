package calculator

class Calculator {
    private val customDelimiterRegex = Regex("//(.)\n(.*)")
    private var defaultDelimiters = arrayOf(",", ":")

    fun add(expression: String?): Int {
        if (expression.isNullOrEmpty()) return 0

        customDelimiterRegex.find(expression)?.let { matchResult ->
            val customDelimiter = matchResult.groupValues[1]
            return processCalculate(expression = matchResult.groupValues[2], customDelimiter = customDelimiter)
        }

        return processCalculate(expression = expression)
    }

    private fun processCalculate(expression: String, customDelimiter: String? = null): Int {
        val delimiters = getDelimiters(customDelimiter)

        val numbers = expression.split(delimiters = delimiters).map { it.toInt() }
        checkNegativeNumber(numbers)
        return numbers.sum()
    }

    private fun getDelimiters(customDelimiter: String?): Array<String> {
        customDelimiter?.let {
            return defaultDelimiters.plus(customDelimiter)
        }

        return defaultDelimiters
    }

    private fun checkNegativeNumber(numbers: List<Int>) {
        numbers.forEach { number ->
            if (number < 0) throw RuntimeException()
        }
    }
}
