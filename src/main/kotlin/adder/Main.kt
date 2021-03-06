package adder

import adder.model.Numbers
import adder.view.InputView
import adder.view.ResultView

fun main() {
    InputView.printQuestion()
    var input = readLine()

    while (input == null) {
        InputView.printQuestion()
        input = readLine()
    }

    val splitInput = InputUtils.split(input)
    val numbers = Numbers(splitInput)
    val sum = numbers.getSum()

    ResultView.printSum(sum)
}
