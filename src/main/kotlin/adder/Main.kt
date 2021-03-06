package adder

fun main() {
    InputView.printQuestion()
    var input = readLine()
    while (input == null) {
        input = readLine()
    }

    val splitInput = InputUtils.split(input)
    val parsedInput = InputUtils.convertToNumber(splitInput)
    val sum = InputUtils.getSum(parsedInput)

    ResultView.printSum(sum)
}
