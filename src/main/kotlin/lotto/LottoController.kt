package lotto

import lotto.domain.LottoBundle
import lotto.domain.LottoPurchaseMachine
import lotto.domain.LottoResult
import lotto.domain.LottoWinningNumbers
import lotto.domain.PurchaseInfo
import lotto.domain.RandomLottoFactory
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private val lottoPurchaseMachine = LottoPurchaseMachine { RandomLottoFactory.generate() }

    fun execute() {
        val purchaseInfo = getPurchaseInfo()
        printPurchaseInfo(purchaseInfo)
        val lottoBundle = getLottoBundle(purchaseInfo)
        printLottoBundle(lottoBundle)

        val lottoWinningNumbers = getLottoWinningNumbers()
        val lottoResult = lottoBundle.getLottoResult(lottoWinningNumbers)
        printLottoStatistics(lottoResult)
        printLottoProfitRate(lottoResult, purchaseInfo)
    }

    private fun getPurchaseInfo(): PurchaseInfo {
        val paidPrice = InputView.getPaidPrice()
        val numberOfManualLotto = InputView.getNumberOfManualLotto()
        val manualLottos = InputView.getManualLottos(numberOfManualLotto)
        return PurchaseInfo(paidPrice, manualLottos)
    }

    private fun printPurchaseInfo(purchaseInfo: PurchaseInfo) {
        OutputView.printNumberOfLotto(purchaseInfo.manualLottoCount(), purchaseInfo.autoLottoCount())
    }

    private fun getLottoBundle(purchaseInfo: PurchaseInfo) = lottoPurchaseMachine.getLottoBundle(purchaseInfo)

    private fun printLottoBundle(lottoBundle: LottoBundle) {
        OutputView.printLottos(lottoBundle.lottos)
    }

    private fun getLottoWinningNumbers(): LottoWinningNumbers {
        val winningNumbers = InputView.getWinningNumbers()
        val bonusNumber = InputView.getBonusNumber()
        return LottoWinningNumbers.of(winningNumbers, bonusNumber)
    }

    private fun printLottoStatistics(lottoResult: LottoResult) {
        val lottoRankStatistic = lottoResult.getLottoRankStatistic()
        OutputView.printLottoRankStatics(lottoRankStatistic)
    }

    private fun printLottoProfitRate(lottoResult: LottoResult, purchaseInfo: PurchaseInfo) {
        val profitRate = lottoResult.getProfitRate(purchaseInfo.lottoBundlePrice())
        OutputView.printProfitRate(profitRate)
    }
}

fun main() {
    LottoController().execute()
}
