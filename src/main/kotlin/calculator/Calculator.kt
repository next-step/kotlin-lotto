package calculator

class Calculator {
    fun add(expression: String?): Int {
        if (expression.isNullOrEmpty()) return 0

        Regex("//(.)\n(.*)").find(expression)?.let { matchResult ->
            val customDelimiter = matchResult.groupValues[1]
            return processCalculate(expression = matchResult.groupValues[2], customDelimiter = customDelimiter)
        }

        return processCalculate(expression = expression)
    }

    private fun processCalculate(expression: String, customDelimiter: String? = null): Int {
        val delimiters = getDelimiters(customDelimiter)

        val numbers = expression.split(delimiters = delimiters).map { it.toInt() }
        checkNegativeNumber(numbers)
        return addNumbers(numbers)
    }

    private fun getDelimiters(customDelimiter: String?): Array<String> {
        var delimiters = arrayOf(",", ":")

        customDelimiter?.let {
            delimiters = delimiters.plus(customDelimiter)
        }

        return delimiters
    }

    private fun checkNegativeNumber(numbers: List<Int>) {
        numbers.forEach { number ->
            if (number < 0) throw RuntimeException()
        }
    }

    private fun addNumbers(numbers: List<Int>): Int {
        var result = 0
        numbers.forEach { number ->
            result += number
        }

        return result
    }
}