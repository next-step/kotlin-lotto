package lotto

import lotto.controller.LottoController
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    LottoController(InputView(), ResultView()).start()
}
