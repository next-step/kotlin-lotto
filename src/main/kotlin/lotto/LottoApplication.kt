package lotto

import lotto.domain.LottoProfitRate
import lotto.domain.LottoPurchaseManager
import lotto.domain.LottoResult
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val lottoApplication = LottoApplication()
    lottoApplication.run()
}

class LottoApplication {
    fun run() {
        val purchaseAmount = InputView.inputPurchaseAmount()
        val lottos = LottoPurchaseManager.purchaseLotto(purchaseAmount)
        ResultView.printLotto(lottos)

        val winnerLottoNumbers = InputView.inputWinnerLottoNumbers()
        val lottoResult = LottoResult(lottos, winnerLottoNumbers)
        val lottoProfitRate = LottoProfitRate(lottoResult, purchaseAmount)
        ResultView.printLottoResult(lottoResult)
        ResultView.printLottoProfitRate(lottoProfitRate)
    }
}
