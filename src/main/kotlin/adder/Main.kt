package adder

import adder.model.Numbers
import adder.view.InputView
import adder.view.ResultView

fun main() {
    InputView.printQuestion()
    var input = readLine()

    while (input?.isBlank()!!) {
        InputView.printQuestion()
        input = readLine()
    }

    val sum = Numbers(input).getSum()
    ResultView.printSum(sum)
}
