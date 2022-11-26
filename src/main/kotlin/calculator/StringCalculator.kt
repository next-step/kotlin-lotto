package calculator

class StringCalculator {

    fun calculate(mathematical: String): Long {
        val expression = Expression.of(mathematical)
        return expression.compute()
    }

}