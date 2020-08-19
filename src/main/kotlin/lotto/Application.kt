package lotto

import lotto.domain.Buyer
import lotto.domain.LottoGenerator
import lotto.domain.LottoNumber
import lotto.domain.LottoStatistics
import lotto.domain.LottoTicket
import lotto.domain.WinningLotto
import lotto.view.InputView
import lotto.view.ResultView

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        val price = InputView.purchasePrice()
        val purchasedCount = Buyer(price).purchasedCount
        val lottoTickets = (1..purchasedCount)
            .map { LottoGenerator.generateNumbers() }
            .map { LottoTicket(it) }

        ResultView.showPurchasedLottos(purchasedCount, lottoTickets)

        val askWinningNumbers = InputView.askWinningNumbers()
        val askBonusNumber = InputView.askBonusNumber()

        val winningLotto = WinningLotto(LottoTicket(askWinningNumbers.split(",")), LottoNumber.get(askBonusNumber))

        val resultPrizeList = lottoTickets.map {
            it.match(winningLotto)
        }
        val lottoStatistics = LottoStatistics(resultPrizeList)
        val ratio = lottoStatistics.calculateRatio(purchasedCount)

        ResultView.showWinningResult(lottoStatistics)
        ResultView.showRatio(ratio)
    }
}
