package stringaddcalculator.controller

import stringaddcalculator.domain.Calculator
import stringaddcalculator.view.InputView
import stringaddcalculator.view.ResultView

fun main() {
    val expression = InputView.inputExpression()
    val result = Calculator().add(expression)
    ResultView.showResult(result)
}
