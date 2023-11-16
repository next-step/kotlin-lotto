package study.lotto.controller

import study.lotto.domain.Lotto
import study.lotto.domain.LottoGameResult
import study.lotto.domain.LottoNumber
import study.lotto.domain.LottoNumbers
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
            .let(LottoNumbers::get)
            .let(::Lotto)

        val bonusNumber = inputView.getBonusNumber().let(::LottoNumber)

        val lottoResult = LottoGameResult.getResult(
            buyingLottoes,
            lastWeekWinningLotto,
            bonusNumber
        )

        resultView.displayStatistics(lottoResult.statistics)
        resultView.displayProfitRate(lottoResult.earningsRate)
    }
}
