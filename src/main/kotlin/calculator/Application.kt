package calculator

import calculator.view.InputView
import calculator.view.ResultView

object Application {
    private val calculator = StringAddCalculator()

    @JvmStatic
    fun main(args: Array<String>) {
        var result = -1
        while (result < 0) {
            result = tryAdd()
        }

        ResultView.printResult(result)
    }

    private fun tryAdd(): Int = try {
        calculator.add(InputView.readExpression())
    } catch (e: Exception) {
        ResultView.printErr()
        -1
    }
}
