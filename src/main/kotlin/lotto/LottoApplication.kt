package lotto

import lotto.controller.LottoController
import lotto.domain.WinningStatistics
import lotto.service.LottoShop
import lotto.view.ResultView

fun main() {
    val lottoController = LottoController()

    val purchaseMoney = lottoController.inputPurchaseMoney()

    val manualLottoCount = lottoController.inputManualLottoCount()
    println("수동으로 구매할 번호를 입력해 주세요.")
    val manualLottos = (1..manualLottoCount)
        .map { lottoController.inputManualLotto() }

    val lottos = LottoShop.purchase(purchaseMoney)
    ResultView.printPurchaseLottoNum(lottos)
    ResultView.printLottos(lottos)
    println()

    val winningLotto = lottoController.inputWinningLotto()
    println()

    val winningStatistics = WinningStatistics.of(lottos, winningLotto)

    ResultView.printStatisticsTitle()
    ResultView.printWinningStatistics(winningStatistics)
    val profitRate = winningStatistics.calculateProfitRate(purchaseMoney)
    ResultView.printProfitRate(profitRate)
}
