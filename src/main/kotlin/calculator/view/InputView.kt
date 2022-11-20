package calculator.view

object InputView {
    private const val DEFAULT_NUMBER = "0"
    fun getExpression(): String {
        val expression: String? = readlnOrNull()
        if (expression.isNullOrEmpty()) return DEFAULT_NUMBER

        return expression
    }
}
