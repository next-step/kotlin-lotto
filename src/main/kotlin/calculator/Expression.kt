package calculator

class Expression(val expressions: List<String>) {

    constructor(expression: String) : this(expression.split(DEFAULT_DELIMITER))

    fun sum(): Int {
        return expressions.sumOf { it.toInt() }
    }

    companion object {
        val DEFAULT_DELIMITER = Regex("[,:]")
        val CUSTOM_DELIMITER = Regex("//(.)\n(.*)")

        fun created(expression: String): Expression {
            return Expression(expression)
        }
    }
}
