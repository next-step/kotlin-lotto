package calculator

import calculator.view.InputView
import calculator.view.OutputView

fun main() {
    val outputView = OutputView()
    val inputView = InputView()

    outputView.initMsg()
    val numbers = inputView.getInputStrAndConvertToList()
    println(numbers)
}
