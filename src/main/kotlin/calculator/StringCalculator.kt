package calculator

fun calculate(formula: String): Int {
    if (formula.isBlank()) {
        return 0
    }
    return runCatching { formula.toInt() }
        .getOrElse { throw IllegalArgumentException("숫자가 아닌 문자를 입력할 수 없다") }
}
