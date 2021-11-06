package lotto

import lotto.domain.Lottos
import lotto.domain.Price
import lotto.domain.ProfitRate
import lotto.domain.WinningNumber
import lotto.domain.generator.LottoAutoStrategy
import lotto.domain.generator.LottoGenerator
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputPrice = InputView.inputPrice() ?: 0
    val lottoCount = Price(inputPrice).getLottoCount()
    OutputView.printBoughtLotto(lottoCount)

    val lottos = LottoGenerator().generate(lottoCount, LottoAutoStrategy())
    OutputView.printBoughtLottos(lottos)

    val inputWinningNumber: List<String> = InputView.inputWinningNumber()
    val inputBonusNumber = InputView.inputBonusNumber() ?: 0
    val winningNumber = WinningNumber.of(inputWinningNumber, inputBonusNumber)

    val matchResult = Lottos(lottos).matchWinningNumber(winningNumber)
    OutputView.printLottoMatchResult(matchResult)

    val profitRate = ProfitRate(matchResult, inputPrice)
    val result = profitRate.calculate()
    OutputView.printProfitRate(result)
}
