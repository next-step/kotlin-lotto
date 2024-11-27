package lotto.app

import lotto.domain.DefaultLottoPurchaseCalculator
import lotto.domain.LottoMatcher
import lotto.domain.LottoNumber
import lotto.domain.LottoService
import lotto.domain.LottoStore
import lotto.domain.PrizeCalculator
import lotto.domain.RandomLottoGenerator
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val lottoGenerator = RandomLottoGenerator()
    val purchaseCalculator = DefaultLottoPurchaseCalculator()
    val lottoStore = LottoStore(lottoGenerator, purchaseCalculator)
    val prizeCalculator = PrizeCalculator()
    val lottoService = LottoService(lottoStore, prizeCalculator)

    val purchaseAmount = InputView.getPurchaseAmount()
    val tickets = lottoService.generateTickets(purchaseAmount)
    ResultView.printPurchaseInfo(tickets)

    val lottoMatcher = LottoMatcher(InputView.getWinningNumbers().map { LottoNumber.of(it) })
    val result = lottoService.playLottoGame(tickets, purchaseAmount, lottoMatcher)

    ResultView.printStatistics(result.getStatistics(), result.getProfitRate())
}
