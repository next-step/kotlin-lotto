package lotto

import lotto.domain.*
import lotto.ui.LottoGamePrinter
import lotto.ui.LottoGameReader

fun main() {
    val amount = LottoGameReader.readAmount()

    val lottos = LottoStore.buy(amount)
    LottoGamePrinter.printPurchaseMessage(lottos)

    val winningLottoNumbers = LottoGameReader.readWinningLottoNumbers()
    val bonusNumber = LottoGameReader.readBonusNumber()
    val winningLotto = WinningLotto(LottoNumbers(winningLottoNumbers), bonusNumber)

    val lottoResults = LottoResultChecker.check(lottos, winningLotto)
    val profitRate = LottoProfitRateCalculator.calculate(lottos, lottoResults)

    LottoGamePrinter.printWinningStatistics(lottoResults, profitRate)
}
