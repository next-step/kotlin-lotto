package stringCalculator

import stringCalculator.domain.StringCalculator
import stringCalculator.view.InputView
import stringCalculator.view.OutputView

fun main() {
    val userInput = InputView.getUserTemplate()
    val resultDigits = StringCalculator.doSplit(userInput)
    OutputView.printAddResult(resultDigits)
}
