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

        val statistics = lottoService.calculateStatistics(tickets, winningNumbers, BonusNumber(bonusNumber))
        val totalPrize = lottoService.calculateTotalPrize(statistics)
        val profitRate = lottoService.calculateProfitRate(totalPrize)

        ResultView.showStatistics(statistics, profitRate)
    }
}
