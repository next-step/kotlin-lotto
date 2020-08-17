package lotto

import lotto.domain.Buyer
import lotto.domain.LottoNumber
import lotto.domain.LottoStatistics
import lotto.domain.LottoTicket
import lotto.domain.WinningLotto
import lotto.domain.result
import lotto.view.InputView
import lotto.view.ResultView

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        val price = InputView.purchasePrice()
        val purchasedCount = Buyer(price).purchasedCount
        val lottoTickets = (1..purchasedCount).map { LottoTicket() }

        ResultView.showPurchasedLottos(purchasedCount, lottoTickets)

        val askWinningNumbers = InputView.askWinningNumbers()
        val askBonusNumber = InputView.askBonusNumber()

        val winningLotto = WinningLotto(LottoTicket(askWinningNumbers.split(",")), LottoNumber.get(askBonusNumber))

        lottoTickets.map {
            it.match(winningLotto)
        }.forEach {
            result[it] = (result[it] ?: 0) + 1
        }

        ResultView.showWinningResult()

        val ratio = LottoStatistics.calculateRatio(purchasedCount)
        ResultView.showRatio(ratio)
    }
}
