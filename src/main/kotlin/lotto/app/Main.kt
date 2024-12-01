package lotto.app

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoStore
import lotto.domain.LottoTickets
import lotto.domain.RandomLottoGenerator
import lotto.domain.WinningLotto
import lotto.domain.WinningStatistics
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()
    val lottoStore = LottoStore(RandomLottoGenerator())

    val manualTicketCount = InputView.getManualTicketCount()
    val manualTickets = InputView.getManualLottoNumbers(manualTicketCount)

    val autoTicketAmount = purchaseAmount - (manualTicketCount * LottoStore.LOTTO_PRICE)
    val autoTickets = lottoStore.sell(autoTicketAmount)
    val tickets = LottoTickets.combine(manualTickets.getTickets(), autoTickets.getTickets())
    ResultView.printPurchaseInfo(tickets, manualTicketCount, autoTickets.size())

    val winningLotto =
        WinningLotto(
            winningLotto = Lotto.of(InputView.getWinningNumbers()),
            bonusNumber = LottoNumber.of(InputView.getBonusNumber()),
        )
    val statistics = WinningStatistics(tickets, winningLotto)
    val profitRate = statistics.calculateProfitRate(purchaseAmount)

    ResultView.printStatistics(statistics, profitRate)
}
