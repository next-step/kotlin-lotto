package study.lotto.controller

import study.lotto.domain.Lotto
import study.lotto.domain.LottoGame
import study.lotto.domain.LottoNumber
import study.lotto.domain.Lottos
import study.lotto.view.InputView
import study.lotto.view.ResultView

class LottoController(
    private val inputView: InputView,
    private val resultView: ResultView,
) {
    fun run() {
        val lottos = Lottos.generateLottos(inputView.getPurchaseAmount())
        resultView.displayLottos(lottos.list.map { it.toIntList() })

        val lastWeekWinningLotto = Lotto.generate(inputView.getLastWeekWinningNumbers().map(::LottoNumber))
        val lottoResult = LottoGame().calculateResult(lottos, lastWeekWinningLotto)
        resultView.displayStatistics(lottoResult.statistics)
        resultView.displayProfitRate(lottoResult.earningsRate)
    }
}
