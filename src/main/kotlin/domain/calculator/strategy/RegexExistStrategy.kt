package domain.calculator.strategy

fun interface RegexExistStrategy {
    fun check(expression: String): Boolean
}
