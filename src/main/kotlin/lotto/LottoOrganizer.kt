package lotto

import lotto.model.*
import lotto.view.InputView
import lotto.view.ResultView


class LottoOrganizer {
    fun start() {
        val lottoPerson = LottoPerson(LottoGenerator)

        val purchasePrice = InputView.getPurchasePrice()
        val manualNumbers = InputView.getManualNumbers()

        val lottoTickets = lottoPerson.buyLottoTickets(
            purchasePrice,
            manualNumbers
        )

        ResultView.renderTicketCount(lottoTickets.size, manualNumbers.size)
        ResultView.renderTickets(lottoTickets)

        val (winningNumbers, bonusNumber) = InputView.getWinningNumbers()

        val winningLotto = WinningLotto(winningNumbers, bonusNumber)

        val lottoResult = winningLotto.getLottoResult(lottoTickets)

        ResultView.renderResults(
            lottoResult.results
        )
        ResultView.renderProfit(
            lottoResult.profit
        )
    }
}
