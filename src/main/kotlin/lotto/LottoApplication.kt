package lotto

import lotto.domain.Lotto
import lotto.domain.Lottos
import lotto.domain.Price
import lotto.domain.ProfitRate
import lotto.domain.WinningNumber
import lotto.domain.generator.LottoAutoStrategy
import lotto.domain.generator.LottoGenerator
import lotto.domain.generator.LottoManualStrategy
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputPrice = InputView.inputPrice() ?: 0
    val lottoCount = Price(inputPrice).getLottoCount()
    val manualLottoCount = InputView.inputManualLottoCount() ?: 0
    val inputtedManualLottoNumbers: List<String> = InputView.inputManualLottoNumbers(manualLottoCount)
    val manualLottos: List<Lotto> = LottoGenerator().generate(manualLottoCount, LottoManualStrategy())

    val autoLottoCount = lottoCount - manualLottoCount
    val autoLottos = LottoGenerator().generate(autoLottoCount, LottoAutoStrategy())
    OutputView.printBoughtLottoCount(manualLottoCount, autoLottoCount)
    OutputView.printBoughtLottos(autoLottos)

    val inputWinningNumber: List<String> = InputView.inputWinningNumber()
    val inputBonusNumber = InputView.inputBonusNumber() ?: 0
    val winningNumber = WinningNumber.of(inputWinningNumber, inputBonusNumber)

    val matchResult = Lottos(autoLottos).matchWinningNumber(winningNumber)
    OutputView.printLottoMatchResult(matchResult)

    val profitRate = ProfitRate(matchResult, inputPrice)
    val result = profitRate.calculate()
    OutputView.printProfitRate(result)
}
