package lotto

import lotto.model.LottoGenerator
import lotto.model.LottoNumber
import lotto.model.LottoPerson
import lotto.model.LottoResultBuilder
import lotto.view.InputView
import lotto.view.ResultView


class LottoOrganizer {
    fun start() {
        val lottoPerson = LottoPerson(LottoGenerator)
        val lottoTickets = lottoPerson.buyLottoTickets(InputView.getPurchasePrice())
        ResultView.renderTicketCount(lottoTickets.size)
        ResultView.renderTickets(lottoTickets)

        val (winningNumbers, bonusNumber) = InputView.getWinningNumbers()
        val lottoResults = LottoResultBuilder.getLottoResults(
            lottoTickets,
            winningNumbers.map { LottoNumber.from(it) },
            LottoNumber.from(bonusNumber)
        )

        ResultView.renderResults(
            lottoResults.results
        )
        ResultView.renderProfit(
            lottoResults.profit
        )
    }
}
