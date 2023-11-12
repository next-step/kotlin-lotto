package lotto

import lotto.model.*
import lotto.view.InputView
import lotto.view.ResultView


class LottoOrganizer {
    fun start() {
        val lottoPerson = LottoPerson(InputView.getPurchasePrice())
        val lottoResults = LottoResults(InputView.getWinningNumbers().map { LottoNumber.from(it) })
        val results = lottoResults.getResult(lottoPerson.lottoTickets.map { it.numbers })
        val profit = lottoResults.getProfit(results)

        ResultView.renderTicketCount(lottoPerson.lottoTickets.size)
        ResultView.renderTickets(lottoPerson.lottoTickets)
        ResultView.renderResults(
            results
        )
        ResultView.renderProfit(
            profit
        )
    }
}
