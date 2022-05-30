package lotto

import lotto.domain.LottoController
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val lottoController = LottoController(InputView(), OutputView())
    lottoController.run()
}
