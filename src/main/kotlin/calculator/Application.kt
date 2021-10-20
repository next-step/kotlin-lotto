현package calculator

import calculator.domain.InputExpressionParser
import calculator.domain.StringAddCalculator
import calculator.view.ConsoleInputView
import calculator.view.ConsoleResultView

class Application {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            CalculatorLauncher(
                ConsoleInputView(),
                ConsoleResultView(),
                StringAddCalculator(InputExpressionParser())
            ).launch()
        }
    }
}
