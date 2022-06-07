package lotto

import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    LottoController(
        inputView = InputView(),
        outputView = OutputView()
    ).startGame()
}
