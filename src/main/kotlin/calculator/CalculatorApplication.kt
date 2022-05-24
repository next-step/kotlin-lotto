package calculator

import calculator.controller.CalculatorController
import calculator.domain.StringAddCalculator
import calculator.view.InputView
import calculator.view.OutputView

fun main() {
    val calculatorController = CalculatorController(
        stringAddCalculator = StringAddCalculator(),
        inputView = InputView(),
        outputView = OutputView()
    )

    calculatorController.run()
}
