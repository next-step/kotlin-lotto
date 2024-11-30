package additioncalculator.view

import additioncalculator.domain.StringAddCalculator

object StringAddCalculatorController {
    fun add() {
        val text = InputView.promptForCalculation()
        ResultView.view(StringAddCalculator.add(text))
    }
}
