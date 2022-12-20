import domain.Calculator
import view.InputView
import view.OutputView

fun main() {
    val text = InputView().input()
    val result = Calculator().sum(text)
    OutputView().printConsole(result)
}
