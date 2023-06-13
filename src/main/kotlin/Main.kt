import domain.ExpressionFactory
import io.InputView
import io.ResultView

fun main() {
    val input = InputView.getInput()
    val expression = ExpressionFactory.createExpression(input)
    ResultView.printResult(expression)
}
