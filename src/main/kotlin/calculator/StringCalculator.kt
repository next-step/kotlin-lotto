package calculator

fun calculate(formula: String): Int {
    if (formula.isBlank()) {
        return 0
    }
    val numbers = formula.split(",", ":")
    return numbers.map { parsePositiveNumber(it) }
        .reduce { total, num -> total + num }
}

private fun parsePositiveNumber(formula: String): Int {
    val number = parseNumber(formula)
    require(number > 0) { "음수는 입력될 수 없다" }
    return number
}

private fun parseNumber(formula: String): Int {
    return runCatching { formula.toInt() }
        .getOrElse { throw IllegalArgumentException("숫자가 아닌 문자를 입력할 수 없다") }
}
