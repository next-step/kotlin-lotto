package stringCalculator.controller

import stringCalculator.domain.Calculator
import stringCalculator.view.InputView

class StringCalculator {
    fun calculate(): Int {
        val input = InputView.inputExpression()
        return Calculator().add(input)
    }
}
