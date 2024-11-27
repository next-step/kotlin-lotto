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
        val manualTicketsInput = InputView.askManualPurchaseNumbers(manualQuantity)!!
        val autoTickets = lottoService.generateAutoTickets(buyQuantity, manualQuantity)
        val manualTickets = manualTicketsInput.map { LottoTicket(it) }
        val tickets = autoTickets + manualTickets
        ResultView.showPurchaseInfo(manualQuantity, buyQuantity - manualQuantity, tickets.map { it.lottoNumbers })

        val winningNumbers = InputView.askWinningNumbers()
        val bonusNumber = InputView.askBonusNumber()

        val statistics = lottoService.calculateStatistics(tickets, winningNumbers, BonusNumber(bonusNumber))
        val totalPrize = lottoService.calculateTotalPrize(statistics)
        val profitRate = lottoService.calculateProfitRate(totalPrize)

        ResultView.showStatistics(statistics, profitRate)
    }
}
