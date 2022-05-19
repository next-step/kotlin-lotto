package string.addition.caculator

import string.addition.caculator.application.Addition
import string.addition.caculator.ui.AdditionResultView
import string.addition.caculator.ui.StringInputView

object StringAdditionCalculatorApp {
    fun launch() {
        val operands = StringInputView.getStrings()
        val result = Addition(operands).result()

        AdditionResultView.display(result)
    }
}

fun main() {
    StringAdditionCalculatorApp.launch()
}
