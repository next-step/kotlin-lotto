package lotto

import lotto.ui.InputView
import lotto.ui.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    val lottoVendor = LottoVendor()

    val price = Price(inputView.getPurchaseMoney())
    resultView.printNumberOfLotto(lottoVendor.getCountOfLotto(price))
    val lottos = lottoVendor.sellLotto(price)
    resultView.printLottos(lottos)
    val winningLotto = inputView.getWinningLotto()
    val winnings = WinningLotto(winningLotto).evaluate(lottos)
    val result = Statistics.getWinningResult(winnings)
    resultView.printResult()
    resultView.printWinningStatistics(result)
    resultView.printYield(Statistics.getYield(result, price))
}
