package lotto

import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    LottoController(InputView(), ResultView()).run()
}
