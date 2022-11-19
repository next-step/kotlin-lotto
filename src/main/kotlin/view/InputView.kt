package view

object InputView {
    fun getExpression(): String {
        val expression: String? = readlnOrNull()
        if (expression.isNullOrEmpty()) return "0"

        return expression
    }
}
