package lotto

import lotto.application.LottoService
import lotto.domain.Price
import lotto.domain.WinningNumber
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputPrice = InputView.inputPrice() ?: 0
    val lottoCount = Price(inputPrice).checkLottoCount()
    InputView.printBoughtLotto(lottoCount)
    val lottoService = LottoService.from(lottoCount)
    OutputView.printBoughtLottos(lottoService.lottos)

    val inputWinningNumber = InputView.inputWinningNumber()
    val winningNumber = WinningNumber(inputWinningNumber)
}
