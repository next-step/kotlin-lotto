package study.lotto.controller

import study.lotto.domain.Lotto
import study.lotto.domain.LottoGameResult
import study.lotto.domain.LottoNumber
import study.lotto.domain.LottoNumbers
import study.lotto.domain.Lottos
import study.lotto.view.InputView
import study.lotto.view.ResultView

class LottoController(
    private val inputView: InputView,
    private val resultView: ResultView,
) {
    fun run() {
        val lottos = Lottos.generateLottos(inputView.getPurchaseAmount())
        resultView.displayLottos(lottos)

        val lastWeekWinningLotto = inputView.getLastWeekWinningNumbers()
            .map(::LottoNumber)
            .let(::LottoNumbers)
            .let(::Lotto)

        val lottoResult = LottoGameResult.getResult(lottos, lastWeekWinningLotto)
        resultView.displayStatistics(lottoResult.statistics)
        resultView.displayProfitRate(lottoResult.earningsRate)
    }
}
