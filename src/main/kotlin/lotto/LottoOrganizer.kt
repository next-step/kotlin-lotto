package lotto

import lotto.model.*
import lotto.view.InputView
import lotto.view.ResultView


class LottoOrganizer {
    fun start() {
        val lottoPerson = LottoPerson(InputView.getPurchasePrice())
        ResultView.renderTicketCount(lottoPerson.lottoTickets.size)
        ResultView.renderTickets(lottoPerson.lottoTickets)

        val (winningNumbers, bonusNumber) = InputView.getWinningNumbers()
        val lottoResults = LottoResults(winningNumbers.map { LottoNumber.from(it) }, LottoNumber.from(bonusNumber))
        val results = lottoResults.getResult(lottoPerson.lottoTickets.map { it.numbers })
        val profit = lottoResults.getProfit(results)

        ResultView.renderResults(
            results
        )
        ResultView.renderProfit(
            profit
        )
    }
}
