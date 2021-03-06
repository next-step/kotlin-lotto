package adder

import adder.model.Numbers

fun main() {
    InputView.printQuestion()
    var input = readLine()
    while (input == null) {
        input = readLine()
    }

    val splitInput = InputUtils.split(input)
    val numbers = Numbers(splitInput)
    val sum = numbers.getSum()

    ResultView.printSum(sum)
}
