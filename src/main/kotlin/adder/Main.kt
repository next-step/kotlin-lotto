package adder

import adder.model.Numbers
import adder.view.InputView
import adder.view.ResultView

fun main() {
    InputView.printQuestion()
    var input = readLine()
    println(input)

    while (input?.isBlank()!!) {
        InputView.printQuestion()
        input = readLine()
    }

    val numbers = Numbers(input)
    val sum = numbers.getSum()

    ResultView.printSum(sum)
}
