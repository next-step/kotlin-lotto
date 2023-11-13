package lotto

import lotto.model.LottoGenerator
import lotto.model.LottoPerson
import lotto.model.LottoResultFactory
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

        val lottoResult = LottoResultFactory.getLottoResult(lottoTickets, winningNumbers, bonusNumber)

        ResultView.renderResults(
            lottoResult.results
        )
        ResultView.renderProfit(
            lottoResult.profit
        )
    }
}
