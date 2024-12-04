package lotto.app

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoStore
import lotto.domain.LottoTickets
import lotto.domain.PurchaseAmount
import lotto.domain.RandomLottoGenerator
import lotto.domain.TicketCount
import lotto.domain.WinningLotto
import lotto.domain.WinningStatistics
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseAmount = PurchaseAmount(InputView.getPurchaseAmount())
    val manualCount = TicketCount(InputView.getManualTicketCount())
    val manualLottoInputs = InputView.getManualLottoNumbers(manualCount.getValue())

    val lottoStore = LottoStore(RandomLottoGenerator())
    val tickets =
        lottoStore.sell(
            LottoTickets(manualLottoInputs.map { Lotto.of(it.split(",").map { n -> n.trim().toInt() }) }),
            purchaseAmount.calculateAutoTicketAmount(manualCount),
        )

    ResultView.printPurchaseInfo(tickets, manualCount)

    val winningNumbers = InputView.getWinningNumbers()
    val bonusNumber = InputView.getBonusNumber()
    val winningLotto =
        WinningLotto(
            Lotto.of(winningNumbers.split(",").map { it.trim().toInt() }),
            LottoNumber.of(bonusNumber),
        )

    val winningCategories = winningLotto.evaluateTickets(tickets)
    val statistics = WinningStatistics(winningCategories)
    val profitRate = statistics.calculateProfitRate(purchaseAmount)

    ResultView.printStatistics(statistics, profitRate)
}
