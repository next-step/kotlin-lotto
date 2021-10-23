package calculator

import calculator.domain.StringAddCalculator
import calculator.view.InputView
import calculator.view.ResultView

class CalculatorLauncher(
    private val inputView: InputView,
    private val resultView: ResultView,
    val calculator: StringAddCalculator
) {
    fun launch() {
        var inputExpression = inputView.receiveInputExpression()

        while (!EXIT_KEY.equals(inputExpression, true)) {
            resultView.showResult(calculator.calculate(inputExpression))
            inputExpression = inputView.receiveInputExpression()
        }
    }

    companion object {
        private const val EXIT_KEY = "x"
    }
}
