package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoGame
import lotto.domain.LottoNumber
import lotto.domain.LottoRank
import lotto.domain.LottoStore
import lotto.domain.ProfitCalculation
import lotto.domain.WinningLotto
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

private fun makeWinningLotto(): WinningLotto {
    val winningNumbers: List<LottoNumber> = InputView.inputWinnerLottoNumbers().map { LottoNumber.from(it) }
    val bonusNumber: Int = InputView.inputBonusNumber()
    return WinningLotto(Lotto(winningNumbers), LottoNumber.from(bonusNumber))
}

private fun showResult(lottoRanks: Map<LottoRank, Int>) {
    ResultView.showWinningStatistics()
    ResultView.showRankCount(lottoRanks)
}

private fun showProfit(lottoRanks: Map<LottoRank, Int>, budget: Int) {
    ResultView.showProfitRate(ProfitCalculation().getProfitRate(lottoRanks, budget))
}
