package lotto

import lotto.domain.LottoPurchaseInfo
import lotto.domain.LottoResult
import lotto.domain.LottoTicket
import lotto.service.AutomaticLottoNumberPackagesGenerator
import lotto.view.input.InputView
import lotto.view.result.ResultView

class LottoGameLauncher(private val inputView: InputView, private val resultView: ResultView) {
    fun launch() {
        val purchaseInfo = LottoPurchaseInfo.from(inputView.getPurchaseAmount())
        resultView.showPurchaseCount(purchaseInfo.purchaseCount)

        val ticket = LottoTicket.from(purchaseInfo.purchaseCount, AutomaticLottoNumberPackagesGenerator())
        resultView.showLottoTicketNumber(ticket)

        val winningInfo = inputView.getWinningInfo()
        resultView.showResultStatistics(LottoResult.from(ticket, winningInfo, purchaseInfo.purchaseAmount))
    }
}
