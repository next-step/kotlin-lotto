package stringcalculator

import stringcalculator.domain.StringAddCalculator
import stringcalculator.domain.StringTokenizer
import stringcalculator.view.InputView
import stringcalculator.view.ResultView

fun main() {
    val inputValue = InputView.input()
    val tokens = StringTokenizer.tokenize(inputValue)
    val resultValue = StringAddCalculator.calculate(tokens)
    ResultView.doResult(resultValue)
}
