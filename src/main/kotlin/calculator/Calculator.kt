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
        if (expression.contains(CUSTOM_DELIMITER_REGEX)) {
            val result = CUSTOM_DELIMITER_REGEX.findAll(expression).first()
            return arrayOf(result.groupValues[1])
        }
        return DEFAULT_DELIMITER
    }

    private fun parsedExpression(expression: String): String {
        if (expression.isBlank()) {
            return ""
        }
        if (expression.contains(CUSTOM_DELIMITER_REGEX)) {
            return expression.replace(CUSTOM_DELIMITER_REGEX, "")
        }
        return expression
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
        private val CUSTOM_DELIMITER_REGEX = Regex("^//(.+)\n")
        private val DEFAULT_DELIMITER = arrayOf(",", ":")
    }
}
