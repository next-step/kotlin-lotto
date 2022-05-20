package calculator

import calculator.processor.CalculatorProcessor
import calculator.view.InputView
import calculator.view.OutputView

fun main() {
    val outputView = OutputView()
    val inputView = InputView()

    outputView.initMsg()
    val numbers = inputView.getInputStrAndConvertToList()

    val result = CalculatorProcessor().add(numbers)
    outputView.result(result)
}
