package lotto

import lotto.domain.LottoGenerator
import lotto.domain.Lottos
import lotto.domain.Price
import lotto.domain.ProfitRate
import lotto.domain.WinningNumber
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputPrice = InputView.inputPrice() ?: 0
    val lottoCount = Price(inputPrice).getLottoCount()
    InputView.printBoughtLotto(lottoCount)

    val lottos = LottoGenerator.generateAutoLotto(lottoCount)
    OutputView.printBoughtLottos(lottos)

    val inputWinningNumber: List<String> = InputView.inputWinningNumber()
    val winningNumber = WinningNumber.from(inputWinningNumber)

    val matchResult = Lottos(lottos).matchWinningNumber(winningNumber)
    OutputView.printLottoMatchResult(matchResult)

    val profitRate = ProfitRate(matchResult, inputPrice)
    val result = profitRate.calculate()
    OutputView.printProfitRate(result)
}
