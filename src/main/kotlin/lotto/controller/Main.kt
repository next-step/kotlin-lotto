package lotto.controller

import lotto.domain.*
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val budget: Int = InputView.inputPrice()
    val count = LottoStore().getPurchasableLottoCount(budget)
    ResultView.showPurchaseLottoCount(count)

    val lotto = LottoStore().buyLotto(count)
    showLotto(lotto)

    val winningLotto = makeWinningLotto()
    val lottoGame = LottoGame(lotto)

    val lottoRanks = lottoGame.matchLotto(winningLotto)
    showResult(lottoRanks)
    showProfit(lottoRanks, budget)
}

private fun showLotto(list: List<Lotto>) {
    list.forEach { lotto ->
        ResultView.showLotto(lotto.lottoNumbers)
    }
}

private fun makeWinningLotto(): Lotto {
    return Lotto(InputView.inputWinnerLottoNumbers().map { LottoNumber.from(it) })
}

private fun showResult(lottoRanks : Map<LottoRank, Int>) {
    ResultView.showWinningStatistics()
    ResultView.showRankCount(lottoRanks)
}

private fun showProfit(lottoRanks : Map<LottoRank, Int>, budget: Int) {
    ResultView.showProfitRate(ProfitCalculation().getProfitRate(lottoRanks, budget))
}
