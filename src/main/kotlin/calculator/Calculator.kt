package calculator

class Calculator(expression: String) {
    private val numbers = numbers(expression)

    init {
        require(hasOnlyPositiveNumbers()) { "[${expression}]은 잘못된 수식입니다."}
    }

    private fun numbers(expression: String): List<String> {
        if (expression.isBlank()) {
            return listOf()
        }

        val delimiter = delimiter(expression)
        val parsedExpression = parsedExpression(expression)
        return parsedExpression.split(*delimiter).toList()
    }

    private fun delimiter(expression: String): Array<String> {
        if (expression.contains(CUSTOM_DELIMITER)) {
            val result = CUSTOM_DELIMITER.findAll(expression).first()
            return arrayOf(result.groupValues[1])
        }
        return DEFAULT_DELIMITER
    }

    private fun parsedExpression(expression: String): String {
        if (expression.contains(CUSTOM_DELIMITER)) {
            return expression.replace(CUSTOM_DELIMITER, "")
        }
        return expression.trim()
    }

    private fun hasOnlyPositiveNumbers(): Boolean {
        return numbers.all { it.matches(Regex("\\d+")) }
    }

    fun exec(): Int {
        if (numbers.isEmpty()) {
            return 0
        }
        return numbers.sumOf { it.toInt() }
    }

    companion object {
        private val CUSTOM_DELIMITER = Regex("^//(.+)\n")
        private val DEFAULT_DELIMITER = arrayOf(",", ":")
    }
}
