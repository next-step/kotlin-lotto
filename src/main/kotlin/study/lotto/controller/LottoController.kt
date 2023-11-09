package study.lotto.controller

import study.lotto.domain.Lotto
import study.lotto.domain.LottoGameResult
import study.lotto.domain.Lottoes
import study.lotto.view.InputView
import study.lotto.view.ResultView

class LottoController(
    private val inputView: InputView,
    private val resultView: ResultView
) {
    fun run() {
        val buyingLottoes = Lottoes.buyLottoes(inputView.getPurchaseAmount())
        resultView.displayLottoes(buyingLottoes)

        val lastWeekWinningLotto = inputView.getLastWeekWinningNumbers()
            .let(Lotto::get)

        val lottoResult = LottoGameResult.getResult(
            buyingLottoes,
            lastWeekWinningLotto
        )

        resultView.displayStatistics(lottoResult.statistics)
        resultView.displayProfitRate(lottoResult.earningsRate)
    }
}
