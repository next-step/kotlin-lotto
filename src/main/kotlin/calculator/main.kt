package calculator

fun main() {
    val inputParser = InputParser()
    val calculator = StringAddCalculator(inputParser)

    print("입력: ")
    val input = readlnOrNull()

    val result = input?.let { calculator.add(it) }
    println("결과: $result")
}
