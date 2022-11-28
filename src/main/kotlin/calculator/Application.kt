package calculator

import calculator.domain.Separator
import calculator.domain.StringAdder
import calculator.view.InputView
import calculator.view.ResultView

fun main() {
    val calculator = StringAdder(
        separator = Separator()
    )

    val expression = InputView.input()

    val result = calculator.calculate(expression)

    ResultView.print(result)
}
