package calculator

fun main() {
    val input = CalculatorView().getInput()
    val result = StringAddCalculator(input).add()
    CalculatorView().displayResult(result)
}
