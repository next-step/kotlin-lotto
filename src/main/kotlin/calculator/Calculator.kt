package calculator

fun main() {
    val expression = InputView.inputExpression()
    val stringAddCalculator = StringAddCalculator.calculate(ExpressionFactory.determine(expression))
    println(stringAddCalculator)
}
