package calculator

import calculator.domain.Calculator
import calculator.domain.ReadStrategySelector
import calculator.ui.InputView
import calculator.ui.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val calculator = Calculator()
    val readStrategySelector = ReadStrategySelector()

    val inputString = inputView.inputString()
    val stringReadStrategy = readStrategySelector.selectStringReadStrategy(inputString)
    val numbers = stringReadStrategy.readString(inputString)
    val result = calculator.calculate(numbers)

    outputView.printCaculateResult(result)
}
