import stringCaculator.domain.Calculator
import stringCaculator.view.InputView
import stringCaculator.view.OutputView

fun main() {
    val text = InputView().input()
    val result = Calculator().sum(text)
    OutputView().printConsole(result)
}
