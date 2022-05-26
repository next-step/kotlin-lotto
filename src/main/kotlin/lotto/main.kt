package lotto

import lotto.domain.LottoController
import lotto.domain.RandomLottoNumberFactory
import lotto.domain.Seller
import lotto.domain.WinningNumber
import lotto.view.InputView
import lotto.view.PrintOutput
import lotto.view.ReadInput
import lotto.view.ResultView

fun main() {
    val lottoController = LottoController(ReadInput(), PrintOutput())

    lottoController.start()
}
