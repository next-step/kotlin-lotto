package calculator

class Calculator {
    fun add(expression: String?): Int {
        if (expression.isNullOrEmpty()) return 0

        var result = 0

        Regex("//(.)\n(.*)").find(expression)?.let { matchResult ->
            val customDelimiter = matchResult.groupValues[1]
            val numbersByCustomDelimiter = matchResult.groupValues[2].split(customDelimiter).map { it.toInt() }
            numbersByCustomDelimiter.forEach { number ->
                result += number
            }

            return result
        }

        val numbers = expression.split(",", ":").map { it.toInt() }
        numbers.forEach { number ->
            result += number
        }

        return result
    }
}