package lotto.app

import lotto.domain.Lotto
import lotto.domain.LottoMatcher
import lotto.domain.LottoNumber
import lotto.domain.LottoStore
import lotto.domain.RandomLottoGenerator
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()
    val lottoStore = LottoStore(RandomLottoGenerator())
    val tickets = lottoStore.sell(purchaseAmount)
    ResultView.printPurchaseInfo(tickets)

    val winningLotto = Lotto.of(InputView.getWinningNumbers())
    val bonusNumber = LottoNumber.of(InputView.getBonusNumber())
    val lottoMatcher = LottoMatcher(winningLotto, bonusNumber)

    val winningStatistics = lottoMatcher.evaluateTickets(tickets)
    val profitRate = winningStatistics.calculateProfitRate(purchaseAmount)
    ResultView.printStatistics(winningStatistics, profitRate)
}
