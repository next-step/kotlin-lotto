package lotto

import lotto.domain.LottoPurchaseManager
import lotto.view.InputView
import lotto.view.LottoResult
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
        val lottoRanks = lottos.mapNotNull { it.matchLotto(winnerLottoNumbers) }
        val lottoResult = LottoResult(lottoRanks)
        ResultView.printLottoResult(lottoResult, purchaseAmount)
    }
}
