package calculator.domain

enum class Operator(
    val symbol: String,
    val calculator: (Int, Int) -> Int
) {
    PLUS("+", { x, y -> x + y }),
    MINUS("-", { x, y -> x - y }),
    MULTIPLY("-", { x, y -> x * y }),
    DIVIDE("-", { x, y ->
        val isZero = x == 0 || y == 0
        if (isZero) 0 else x / y
    });
}
