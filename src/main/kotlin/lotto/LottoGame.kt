package lotto

import lotto.domain.*

fun main() {
    val amount = LottoGameReader.readAmount()

    val lottos = LottoStore.buy(amount)
    LottoGamePrinter.printPurchaseMessage(lottos)

    val winningLottoNumbers = LottoGameReader.readWinningLottoNumbers()
    val winningLotto = WinningLotto(winningLottoNumbers)

    val lottoResults = LottoResultChecker.check(lottos, winningLotto)
    val profitRate = LottoProfitRateCalculator.calculate(lottos, lottoResults)

    LottoGamePrinter.printWinningStatistics(lottoResults, profitRate)
}