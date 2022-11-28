package stringcalculator

class Calculator(private val expression: Expression) {

    fun calculate(): Int {
        return expression.tokens.sum()
    }

    companion object {
        fun from(expression: String?): Calculator {
            return Calculator(Expression.from(expression))
        }
    }
}
