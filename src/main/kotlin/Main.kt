import domain.ExpressionFactory
import io.InputView

fun main() {
    val input = InputView.getInput()
    val expression = ExpressionFactory.createExpression(input)
}
