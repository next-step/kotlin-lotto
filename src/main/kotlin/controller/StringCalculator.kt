package controller

import domain.Calculator
import view.InputView

class StringCalculator {
    fun calculate() : Int{
        val input = InputView.inputExpression()
        return Calculator().add(input)
    }
}
