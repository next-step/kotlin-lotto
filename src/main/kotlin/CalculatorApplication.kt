import view.InputView
import view.OutputView

fun main() {
    val expression = InputView.getExpression()
    val result = Calculator().execute(expression)

    OutputView.printResult(result)
}
