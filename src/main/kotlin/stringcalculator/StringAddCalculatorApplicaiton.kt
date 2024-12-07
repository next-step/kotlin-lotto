package stringcalculator

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    val calculator = StringAddCalculator()
    val expressionInput = inputView.getExpressionInput()
    val result = calculator.calculate(expressionInput)
    resultView.renderResult(result)
}
