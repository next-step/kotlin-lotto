package lotto

import lotto.domain.Lotto
import lotto.domain.LottoStatistics
import lotto.domain.Lottos
import lotto.domain.Money
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    val budget = inputView.budget()
    val lottos = Lottos.buyRandom(budget)
    resultView.printBoughtResult(lottos)

    val latestWinnerLotto = Lotto(inputView.latestWinnerLotto())
    val statistics = LottoStatistics(lottos = lottos, target = latestWinnerLotto)
    val profit: Money = statistics.profit(budget)
    resultView.printStatistics(statistics = statistics, profit = profit)
}
