package lotto

import lotto.controller.LottoController
import lotto.domain.WinningStatistics
import lotto.view.ResultView

fun main() {
    val lottoController = LottoController()
    val (lottos, purchaseMoney) = lottoController.purchaseLottos()

    ResultView.printPurchaseLottoNum(lottos)
    ResultView.printLottos(lottos)
    println()

    val winningLotto = lottoController.inputWinningLotto()
    println()

    val winningStatistics = WinningStatistics.of(lottos) { lotto -> winningLotto.rank(lotto) }

    ResultView.printStatisticsTitle()
    ResultView.printWinningStatistics(winningStatistics)
    val profitRate = winningStatistics.calculateProfitRate(purchaseMoney)
    ResultView.printProfitRate(profitRate)
}
