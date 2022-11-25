package calculator

class StringCalculator {

    fun calculate(mathematical: String): Long {
        if(mathematical.isNullOrBlank()) return 0

        val expression = Expression.of(mathematical)
        return expression.compute()
    }

}