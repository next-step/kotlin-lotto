package lotto

import lotto.ui.InputView
import lotto.ui.OutputView

fun main() {

    val lottoController = LottoController(LottoManager(), OutputView(), InputView())
    lottoController.execute()
}
