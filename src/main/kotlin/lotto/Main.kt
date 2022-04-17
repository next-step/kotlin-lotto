package lotto

import lotto.domain.Lotto
import lotto.domain.Lottos
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    val price = inputView.price()
    val lottos = Lottos.buyRandom(price)
    resultView.printBoughtResult(lottos)
    val matchLotto = Lotto(inputView.lastWeekMatchNumbers())
    val lottoResult = lottos.matchAll(matchLotto)
    resultView.printStatistics(lottoResult)
}
