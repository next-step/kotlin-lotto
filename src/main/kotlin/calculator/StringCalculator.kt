package calculator

class StringCalculator {
    fun calculate(expression: String): Long {
        val numbers = extractNumbers(expression)

        return numbers.sum()
    }

    private fun extractNumbers(expression: String): List<Long> {
        if (expression.contains(",")) {
            return expression.split(",")
                .map(String::toLong)
        }
        return expression.split(":")
            .map(String::toLong)
    }

}
