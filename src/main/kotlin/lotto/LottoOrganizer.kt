package lotto

import lotto.model.LottoGenerator
import lotto.model.LottoPerson
import lotto.model.LottoResultBuilder
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
        val lottoResults = LottoResultBuilder.getLottoResults(
            lottoTickets,
            winningNumbers,
            bonusNumber
        )

        ResultView.renderResults(
            lottoResults.results
        )
        ResultView.renderProfit(
            lottoResults.profit
        )
    }
}
