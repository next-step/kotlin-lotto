package lotto.app

import lotto.domain.LottoFactory
import lotto.domain.LottoStore
import lotto.domain.LottoTickets
import lotto.domain.PurchaseAmount
import lotto.domain.RandomLottoGenerator
import lotto.domain.TicketCount
import lotto.domain.WinningStatistics
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseAmount = PurchaseAmount(InputView.getPurchaseAmount())

    val manualCount = TicketCount(InputView.getManualTicketCount())
    val manualLottoInputs = InputView.getManualLottoNumbers(manualCount.getValue())
    val manualTickets = LottoFactory.createManualTickets(manualLottoInputs)

    val autoTicketAmount = purchaseAmount.calculateAutoTicketAmount(manualCount)
    val lottoStore = LottoStore(RandomLottoGenerator())
    val autoTickets = lottoStore.sell(autoTicketAmount)
    val tickets = LottoTickets.combine(manualTickets.getTickets(), autoTickets.getTickets())

    ResultView.printPurchaseInfo(tickets, manualCount)

    val winningNumbers = InputView.getWinningNumbers()
    val bonusNumber = InputView.getBonusNumber()
    val winningLotto = LottoFactory.createWinningLotto(winningNumbers, bonusNumber)

    val winningCategories = winningLotto.evaluateTickets(tickets)
    val statistics = WinningStatistics(winningCategories)
    val profitRate = statistics.calculateProfitRate(purchaseAmount)

    ResultView.printStatistics(statistics, profitRate)
}
