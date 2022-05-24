package calculator.controller

import calculator.domain.StringAddCalculator
import calculator.view.InputView
import calculator.view.OutputView

class CalculatorController(
    private val stringAddCalculator: StringAddCalculator,
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    fun run() {
        val inputText = inputView.inputText()
        val result = stringAddCalculator.add(text = inputText)
        outputView.printResult(result = result)
    }
}
