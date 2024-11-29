package lotto.app

import lotto.domain.DefaultLottoPurchaseCalculator
import lotto.domain.Lotto
import lotto.domain.LottoGameManager
import lotto.domain.LottoMatcher
import lotto.domain.LottoNumber
import lotto.domain.LottoStore
import lotto.domain.ProfitCalculator
import lotto.domain.RandomLottoGenerator
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()
    val lottoStore = LottoStore(RandomLottoGenerator(), DefaultLottoPurchaseCalculator())
    val tickets = lottoStore.sell(purchaseAmount)
    ResultView.printPurchaseInfo(tickets)

    val lottoMatcher = LottoMatcher(Lotto.of(InputView.getWinningNumbers()), LottoNumber.of(InputView.getBonusNumber()))
    val lottoGameManager = LottoGameManager()
    val winningStatistics = lottoGameManager.playLottoGame(tickets, lottoMatcher)
    val profitCalculator = ProfitCalculator()
    val profitRate = profitCalculator.calculateProfitRate(winningStatistics.calculateTotalPrize(), purchaseAmount)
    ResultView.printStatistics(winningStatistics, profitRate)
}
