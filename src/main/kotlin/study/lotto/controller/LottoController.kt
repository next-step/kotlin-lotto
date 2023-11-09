package study.lotto.controller

import study.lotto.domain.Lotto
import study.lotto.domain.LottoGame
import study.lotto.view.InputView
import study.lotto.view.ResultView

class LottoController(
    private val inputView: InputView,
    private val resultView: ResultView,
) {
    fun run() {
        val lottoGame = LottoGame(inputView.getPurchaseAmount())
        resultView.displayLottoes(lottoGame.buyingLottoes)

        val lastWeekWinningLotto = inputView.getLastWeekWinningNumbers()
            .let(Lotto::get)

        val lottoResult = lottoGame.getResult(lastWeekWinningLotto)

        resultView.displayStatistics(lottoResult.statistics)
        resultView.displayProfitRate(lottoResult.earningsRate)
    }
}
