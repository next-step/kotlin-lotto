package lotto

import lotto.domain.Lotto
import lotto.domain.LottoPurchaseMachine
import lotto.domain.LottoResult
import lotto.domain.LottoWinningNumbers
import lotto.domain.PurchaseInfo
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    fun execute() {
        val purchaseInfo = getPurchaseInfo()
        printPurchaseInfo(purchaseInfo)
        val lottos = getLottos(purchaseInfo)
        printLottos(lottos)

        val lottoWinningNumbers = getLottoWinningNumbers()
        val lottoResult = lottoWinningNumbers.getLottoResult(lottos)
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

    private fun getLottos(purchaseInfo: PurchaseInfo) = LottoPurchaseMachine.getLottos(purchaseInfo)

    private fun printLottos(lottos: List<Lotto>) {
        OutputView.printLottos(lottos)
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
        val profitRate = lottoResult.getProfitRate(purchaseInfo.totalLottosPrice())
        OutputView.printProfitRate(profitRate)
    }
}

fun main() {
    LottoController().execute()
}
