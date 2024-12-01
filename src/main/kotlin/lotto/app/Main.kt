package lotto.app

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoStore
import lotto.domain.LottoTickets
import lotto.domain.RandomLottoGenerator
import lotto.domain.TicketCount
import lotto.domain.WinningLotto
import lotto.domain.WinningStatistics
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()
    val lottoStore = LottoStore(RandomLottoGenerator())

    val manualCount = InputView.getManualTicketCount()
    val manualTickets = InputView.getManualLottoNumbers(manualCount.getValue())

    val autoTicketAmount = purchaseAmount.getValue() - (manualCount.getValue() * LottoStore.LOTTO_PRICE)
    val autoCount = TicketCount(autoTicketAmount / LottoStore.LOTTO_PRICE)
    val autoTickets = lottoStore.sell(autoTicketAmount)

    val tickets = LottoTickets.combine(manualTickets.getTickets(), autoTickets.getTickets())
    ResultView.printPurchaseInfo(tickets, manualCount, autoCount)

    val winningLotto =
        WinningLotto(
            winningLotto = Lotto.of(InputView.getWinningNumbers()),
            bonusNumber = LottoNumber.of(InputView.getBonusNumber()),
        )
    val statistics = WinningStatistics(tickets, winningLotto)
    val profitRate = statistics.calculateProfitRate(purchaseAmount)

    ResultView.printStatistics(statistics, profitRate)
}
