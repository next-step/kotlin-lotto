package caculator.ui

import caculator.StringAddCalculator

fun main() {
    OutputView().view(
        StringAddCalculator(InputView(SystemInputStrategy()).value)
            .calculate()
            .toString()
    )
}
