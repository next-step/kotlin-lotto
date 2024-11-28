package string_calculator

fun main() {
    val input = InputView("Enter input: ").getInputMessage()
    val calculator = StringAddCalculator()
    val result = calculator.calculate(input)
    ResultView("Result: $result").render()
}