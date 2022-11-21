import calculator.domain.Expression
import calculator.domain.StringAddCalculator
import calculator.view.InputView

fun main() {
    val calculator = StringAddCalculator()
    println(calculator.add(Expression(InputView().getUserInput())))
}
