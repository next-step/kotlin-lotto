package stringcalculator.controller

import stringcalculator.domain.Calculator
import stringcalculator.view.InputView

class StringCalculator {
    fun calculate(): Int {
        val input = InputView.inputExpression()
        return Calculator().add(input)
    }
}
