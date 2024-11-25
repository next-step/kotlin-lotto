package additioncalculator.view

import additioncalculator.domain.StringAddCalculator

class StringAddCalculatorController {
    fun add() {
        val text: String? = InputView().view()
        val stringAddCalculator = StringAddCalculator()
        ResultView().view(stringAddCalculator.add(text))
    }
}