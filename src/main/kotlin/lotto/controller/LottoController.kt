package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoRank
import lotto.domain.LottoTicket
import lotto.service.LottoService
import lotto.view.InputView
import lotto.view.ResultView

class LottoController {
    fun run() {
        val purchaseAmount = InputView.askPurchaseAmount()
        val lotto = Lotto(purchaseAmount)
        val lottoService = LottoService(lotto)

        val tickets = lottoService.lottoIssuance()
        ResultView.showPurchaseInfo(tickets.size, tickets.map { it.numbers() })

        val winningNumbers = InputView.askWinningNumbers()

        val statistics = tickets.groupingBy { ticket ->
            LottoRank.from(ticket.matchCount(winningNumbers))
        }.eachCount()

        val totalPrize = statistics.entries.sumOf { (rank, count) ->
            rank.prize * count
        }

        val profitRate = lottoService.calculateProfitRate(totalPrize)

        ResultView.showStatistics(statistics, profitRate)
    }
}
