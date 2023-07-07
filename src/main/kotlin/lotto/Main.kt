package lotto

import lotto.domain.RandomLottoNumberGenerator
import lotto.ui.InputView
import lotto.ui.OutputView

fun main() {

    val lottoController = LottoController(OutputView(), InputView(), RandomLottoNumberGenerator())
    lottoController.execute()
}
