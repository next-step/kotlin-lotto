package calculator

class Calculator(expression: Expression) {
    private val numbers = numbers(expression)

    init {
        require(numbers.all { it.isPositiveOrZero }) { "[$expression]은 잘못된 수식입니다." }
    }

    private fun numbers(expression: Expression): List<Number> {
        if (expression.isBlank) {
            return listOf()
        }

        val delimiter = expression.delimiter()
        val parsedExpression = expression.parsedExpression()
        return parsedExpression.split(*delimiter).map { Number(it) }
    }

    fun sum(): Int {
        if (numbers.isEmpty()) {
            return 0
        }
        return numbers.sumOf { it.value }
    }
}
