package lotto

import lotto.domain.LottoMachine
import lotto.ui.InputView
import lotto.ui.OutputView

fun main() {

    val lottoController = LottoController(LottoManager(LottoMachine()), OutputView(), InputView())
    lottoController.execute()
}
