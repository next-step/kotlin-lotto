package lotto

import lotto.ui.InputView
import lotto.ui.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()

    val controller = Controller(inputView, resultView)
    controller.startLotto()
}
