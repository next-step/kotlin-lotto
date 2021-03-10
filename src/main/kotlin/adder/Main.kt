package adder

import adder.model.Numbers
import adder.view.InputView
import adder.view.ResultView

fun main() {
    val answer = InputView.askQuestion()
    val sum = Numbers(answer).getSum()
    ResultView.printSum(sum)
}
