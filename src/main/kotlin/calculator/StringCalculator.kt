package calculator

class StringCalculator {
    fun calculate(expression: String?): Long {
        if (expression.isNullOrEmpty()) {
            return 0
        }

        return expression.split("[,:]".toRegex())
            .map(String::toLong)
            .sum()
    }
}
