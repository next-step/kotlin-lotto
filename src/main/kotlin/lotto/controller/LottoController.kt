package lotto.controller

import lotto.domain.BonusNumber
import lotto.domain.LottoPurchasingMachine
import lotto.domain.LottoRank
import lotto.domain.LottoTicket
import lotto.service.LottoService
import lotto.view.InputView
import lotto.view.ResultView

object LottoController {
    fun run() {
        val purchaseAmount = InputView.askPurchaseAmount()
        val lottoService = LottoService(LottoPurchasingMachine(purchaseAmount))

        val buyQuantity = LottoPurchasingMachine(purchaseAmount).buyCount()
        val manualQuantity = InputView.askManualPurchaseAmount()

        val manualTicketsInput = InputView.askManualPurchaseNumbers(manualQuantity)
        if (manualTicketsInput.size != 6) {
            println(LottoTicket.LOTTO_NUMBER_SIZE_EXCEPTION_MESSAGE)
        }

        val manualTickets = manualTicketsInput.map { LottoTicket(it) }
        val autoTickets = lottoService.generateAutoTickets(buyQuantity, manualQuantity)
        val tickets = autoTickets + manualTickets

        ResultView.showPurchaseInfo(manualQuantity, buyQuantity - manualQuantity, tickets.map { it.lottoNumbers })

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
