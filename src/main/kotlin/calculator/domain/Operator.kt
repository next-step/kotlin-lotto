package calculator.domain

enum class Operator(
    val symbol: String,
    val calculator: (Int, Int) -> Int
) {
    PLUS("+", { x, y -> x + y })
}
