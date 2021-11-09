package lotto

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
    val manualLottos = LottoGenerator().generate(inputtedManualLottoNumbers, LottoManualStrategy())

    val autoLottoCount = lottoCount - manualLottoCount
    val autoLottos = LottoGenerator().generate(autoLottoCount, LottoAutoStrategy())

    val totalLottos = manualLottos.plus(autoLottos)
    OutputView.printBoughtLottoCount(manualLottoCount, autoLottoCount)
    OutputView.printBoughtLottos(totalLottos)

    val inputWinningNumber: List<String> = InputView.inputWinningNumber()
    val inputBonusNumber = InputView.inputBonusNumber() ?: 0
    val winningNumber = WinningNumber.of(inputWinningNumber, inputBonusNumber)

    val matchResult = Lottos(totalLottos).matchWinningNumber(winningNumber)
    OutputView.printLottoMatchResult(matchResult)

    val profitRate = ProfitRate(matchResult, inputPrice)
    val result = profitRate.calculate()
    OutputView.printProfitRate(result)
}
