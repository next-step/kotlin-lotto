package expressioncalculator

fun main() {
    val calculator = Calculator(
        inputConverter = InputConverter,
        expressionParser = ExpressionParser
    )

    val result = calculator.calculate(readlnOrNull())
    println(result)
}
