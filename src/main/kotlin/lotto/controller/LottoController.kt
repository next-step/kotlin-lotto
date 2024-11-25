package lotto.controller

import lotto.domain.BonusNumber
import lotto.domain.LottoPurchasingMachine
import lotto.domain.LottoRank
import lotto.service.LottoService
import lotto.view.InputView
import lotto.view.ResultView

object LottoController {
    fun run() {
        val purchaseAmount = InputView.askPurchaseAmount()
        val lottoPurchasingMachine = LottoPurchasingMachine(purchaseAmount)
        val lottoService = LottoService(lottoPurchasingMachine)

        val tickets = lottoService.lottoIssuance()
        ResultView.showPurchaseInfo(tickets.size, tickets.map { it.lottoNumbers })

        val winningNumbers = InputView.askWinningNumbers()
        val bonusNumber = InputView.askBonusNumber()

        val statistics =
            tickets.groupingBy { ticket ->
                val matchCount = ticket.matchCount(winningNumbers)
                val hasBonus = matchCount == 5 && ticket.hasBonusNumber(BonusNumber(bonusNumber))
                LottoRank.from(matchCount, hasBonus)
            }.eachCount()

        val totalPrize =
            statistics.entries.sumOf { (rank, count) ->
                rank.prize * count
            }

        val profitRate = lottoService.calculateProfitRate(totalPrize)

        ResultView.showStatistics(statistics, profitRate)
    }
}
