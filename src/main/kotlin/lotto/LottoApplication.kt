package lotto

import lotto.controller.LottoController
import lotto.view.ResultView

fun main() {
    val lottoController = LottoController()
    val (lottos, purchaseMoney) = lottoController.purchaseLottos()

    ResultView.printPurchaseLottoNum(lottos)
    ResultView.printLottos(lottos)

    val winningLotto = lottoController.inputWinningLotto()
    println()

    val winningStatistics = lottos.match(winningLotto)

    ResultView.printWinningStatistics(winningStatistics)

    val profitRate = winningStatistics.calculateProfitRate(purchaseMoney)
    ResultView.printProfitRate(profitRate)
}
