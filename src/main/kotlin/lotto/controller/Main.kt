package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoGame
import lotto.domain.LottoRank
import lotto.domain.Money
import lotto.domain.ProfitCalculation
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val budget: Int = InputView.inputPrice()
    val lotto = buyNShowLotto(budget)
    val lottoGame = calculateWinningLotto(lotto)
    showResult(lottoGame)
    showProfit(lottoGame, budget)
}

private fun buyNShowLotto(budget: Int): List<Lotto> {
    val money = Money(budget)
    val count = calculateCanBuyLotto(money)
    val lotto = buyLotto(count, money)
    showLotto(lotto)
    return lotto
}

private fun buyLotto(count: Int, money: Money): List<Lotto> {
    return money.requestBuyLotto(count)
}

private fun showLotto(list: List<Lotto>) {
    list.forEach { lotto ->
        ResultView.showLotto(lotto.lottoNumbers.joinToString { "$it" })
    }
}

private fun calculateCanBuyLotto(money: Money): Int {
    val count = money.requestLottoPurchaseCount()
    ResultView.showPurchaseLottoCount(count)
    return count
}

private fun calculateWinningLotto(lotto: List<Lotto>): LottoGame {
    val winnerNumbers = InputView.inputWinnerLottoNumbers()
    val lottoGame = LottoGame(winnerNumbers)
    lotto.forEach {
        val count = lottoGame.findMatchCount(it.lottoNumbers)
        lottoGame.addMatchedLottoRankCount(LottoRank.matchRank(count))
    }

    return lottoGame
}

private fun showResult(lottoGame: LottoGame) {
    ResultView.showWinningStatistics()

    for (i in 0 until LottoRank.values().size - 1) {
        ResultView.showRankCount(lottoGame.getRankCount(LottoRank.values()[i]), LottoRank.values()[i])
    }
}

private fun showProfit(lottoGame: LottoGame, budget: Int) {
    ResultView.showProfitRate(ProfitCalculation().getProfitRate(lottoGame, budget))
}
