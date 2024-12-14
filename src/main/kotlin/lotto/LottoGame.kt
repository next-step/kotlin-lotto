package lotto

import lotto.common.RetryHandler
import lotto.domain.Amount
import lotto.domain.LottoProfitRateCalculator
import lotto.domain.LottoResultChecker
import lotto.domain.LottoStore
import lotto.domain.UserLottos
import lotto.domain.WinningLotto
import lotto.ui.LottoGamePrinter
import lotto.ui.LottoGameReader

fun main() {
    val amount = LottoGameReader.readAmount()

    val lottos = buyLottos(amount)
    val winningLotto = createWinningLotto()

    val lottoResults = LottoResultChecker.check(lottos, winningLotto)
    val profitRate = LottoProfitRateCalculator.calculate(lottos, lottoResults)

    LottoGamePrinter.printWinningStatistics(lottoResults, profitRate)
}

private fun buyLottos(amount: Amount): UserLottos {
    val manualCount = readManualCount(amount)
    val manualLottos = LottoGameReader.readManualLottos(manualCount)
    val lottos = LottoStore.buy(manualLottos, amount)
    LottoGamePrinter.printPurchaseMessage(manualLottos, lottos)
    return lottos
}

private fun readManualCount(amount: Amount): Int {
    return RetryHandler.retryIfFail(
        mainAction = {
            val manualCount = LottoGameReader.readManualCount()
            amount.validatePurchasable(manualCount)
            manualCount
        },
        retryAction = {
            readManualCount(amount)
        }
    )
}

private fun createWinningLotto(): WinningLotto {
    return RetryHandler.retryIfFail(
        mainAction = {
            val winningLottoNumbers = LottoGameReader.readWinningLottoNumbers()
            val bonusNumber = LottoGameReader.readBonusNumber()
            WinningLotto(winningLottoNumbers, bonusNumber)
        },
        retryAction = {
            createWinningLotto()
        }
    )
}
