package calculator

class StringCalculator {
    fun calculate(expression: String): Long {
        return expression.split(",")
            .map { it.toLong() }
            .reduce { acc, l -> acc + l }
    }

}
