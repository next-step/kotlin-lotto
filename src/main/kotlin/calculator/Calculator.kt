package calculator

class Calculator {
    fun add(expression: String?): Int {
        if (expression.isNullOrEmpty()) return 0

        val numbers = expression.split(",", ":").map { it.toInt() }

        var result = 0
        numbers.forEach { number ->
            result += number
        }

        return result
    }
}