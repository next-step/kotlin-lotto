package calculator

fun main() {
    val text = InputView.getInput()
    ResultView.printResult(Calculator(text).result)
}
