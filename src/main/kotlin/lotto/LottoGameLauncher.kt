package lotto

import lotto.domain.LottoPurchaseCount
import lotto.domain.LottoPurchaseInfo
import lotto.domain.LottoTicket
import lotto.service.AutomaticLottoNumberPackagesGenerator
import lotto.view.input.InputView
import lotto.view.result.ResultView

class LottoGameLauncher(private val inputView: InputView, private val resultView: ResultView) {
    fun launch() {
        val purchaseAmount = inputView.getPurchaseAmount()
        val purchaseCount = LottoPurchaseCount.from(purchaseAmount.amount)
        resultView.showPurchaseCount(purchaseCount)

        LottoTicket.from(LottoPurchaseInfo(purchaseCount, purchaseAmount), AutomaticLottoNumberPackagesGenerator())
    }
}
