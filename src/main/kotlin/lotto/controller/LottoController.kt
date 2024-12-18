package lotto.controller

import lotto.domain.LottoTickets
import lotto.view.InputView
import lotto.view.OutputView

object LottoController {
    fun startLottoGame() {
        val purchasedDetail = InputView.getPurchaseDetail()
        val autoLottoTickets = LottoTickets.generateAutoLottoTickets(purchasedDetail.autoLottoQuantity)
        val lottoTickets = LottoTickets(purchasedDetail.manualLottoTickets + autoLottoTickets)
        OutputView.printPurchaseResult(lottoTickets, purchasedDetail)
        val winningLotto = InputView.getUserWinningLotto()
        val lottoResults = lottoTickets.calculateLottoRank(winningLotto)
        OutputView.printResults(lottoResults, purchasedDetail.purchaseAmount)
    }
}
