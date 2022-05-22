package calculator

class Calculator {
    fun add(expression: String?): Int {
        if (expression.isNullOrEmpty()) return 0

        Regex("//(.)\n(.*)").find(expression)?.let { matchResult ->
            val customDelimiter = matchResult.groupValues[1]
            val numbersByCustomDelimiter = matchResult.groupValues[2].split(customDelimiter).map { it.toInt() }
            return addNumbers(numbersByCustomDelimiter)
        }

        val numbers = expression.split(",", ":").map { it.toInt() }
        return addNumbers(numbers)
    }

    private fun addNumbers(numbers: List<Int>): Int {
        var result = 0
        numbers.forEach { number ->
            result += number
        }

        return result
    }
}