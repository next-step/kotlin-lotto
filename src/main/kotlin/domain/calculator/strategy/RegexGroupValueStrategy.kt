package domain.calculator.strategy

fun interface RegexGroupValueStrategy {
    fun groupValue(expression: String, index: Int): String
}
