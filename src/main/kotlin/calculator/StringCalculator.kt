package calculator

fun calculate(formula: String): Int {
    if (formula.isBlank()) {
        return 0
    }
    val numbers = formula.split(",", ":")
    return numbers.map { PositiveNumber.from(it) }
        .reduce { total, num -> total + num }
        .value
}
