package lotto.app

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoStore
import lotto.domain.RandomLottoGenerator
import lotto.domain.WinningLotto
import lotto.domain.WinningStatistics
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()
    val lottoStore = LottoStore(RandomLottoGenerator())
    val tickets = lottoStore.sell(purchaseAmount)
    ResultView.printPurchaseInfo(tickets)

    val winningLotto =
        WinningLotto(
            winningLotto = Lotto.of(InputView.getWinningNumbers()),
            bonusNumber = LottoNumber.of(InputView.getBonusNumber()),
        )
    val statistics = WinningStatistics(tickets, winningLotto)
    val profitRate = statistics.calculateProfitRate(purchaseAmount)
    ResultView.printStatistics(statistics, profitRate)
}
