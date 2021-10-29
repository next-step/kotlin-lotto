package lotto

import lotto.application.LottoService
import lotto.domain.Price
import lotto.domain.ProfitRate
import lotto.domain.WinningNumber
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputPrice = InputView.inputPrice() ?: 0
    val lottoCount = Price(inputPrice).checkLottoCount()
    InputView.printBoughtLotto(lottoCount)

    val lottoService = LottoService.generateAutoLotto(lottoCount)
    OutputView.printBoughtLottos(lottoService.lottos)

    val inputWinningNumber: List<String> = InputView.inputWinningNumber()
    val winningNumber = WinningNumber.from(inputWinningNumber)
    val matchResult = lottoService.matchWinningNumber(winningNumber)

    OutputView.printLottoMatchResult(matchResult)
    val profitRate = ProfitRate(matchResult, inputPrice)
    val result = profitRate.calculate()
}
