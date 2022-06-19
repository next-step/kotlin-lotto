package stringcalculator.controller

import stringcalculator.domain.Calculator
import stringcalculator.view.InputView
import stringcalculator.view.OutputView

class StringCalculator {
    fun calculate() {
        val input = InputView.inputExpression()
        OutputView.printResult(Calculator().add(input))
    }
}
