package calculator

class Calculator {
    fun add(expression: String?): Int {
        if (expression.isNullOrEmpty()) return 0

        Regex("//(.)\n(.*)").find(expression)?.let { matchResult ->
            val customDelimiter = matchResult.groupValues[1]
            val numbersByCustomDelimiter = matchResult.groupValues[2].split(customDelimiter).map { it.toInt() }
            checkNegativeNumber(numbersByCustomDelimiter)

            return addNumbers(numbersByCustomDelimiter)
        }

        val numbers = expression.split(",", ":").map { it.toInt() }
        checkNegativeNumber(numbers)
        return addNumbers(numbers)
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