import calculator.domain.ExpressionFactory
import calculator.io.ResultView

fun main() {
    val input = "//;\n1;2;3"
    val expression = ExpressionFactory.createExpression(input)
    ResultView.printResult(expression)
}
