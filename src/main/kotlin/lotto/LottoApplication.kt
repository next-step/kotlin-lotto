package lotto

import lotto.domain.WinningStatistics
import lotto.service.LottoCalculator
import lotto.service.LottoShop
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseMoney = InputView.purchaseMoney()
    val lottos = LottoShop.purchase(purchaseMoney)
    ResultView.printPurchaseLottoNum(lottos)
    ResultView.printLottos(lottos)
    println()

    val winningLotto = InputView.winningLotto()
    println()

    val winningStatistics = WinningStatistics.of(lottos, winningLotto)

    ResultView.printStatisticsTitle()
    ResultView.printWinningStatistics(winningStatistics)
    val profitRate = LottoCalculator.calculateProfitRate(winningStatistics.calculateTotalPrizeMoney(), purchaseMoney)
    ResultView.printProfitRate(profitRate)
}
