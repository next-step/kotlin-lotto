package lotto.application

import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import lotto.domain.LottoResultService
import lotto.domain.LottoStatistics
import lotto.util.NumberGenerator
import lotto.view.InputView
import lotto.view.ResultView

class Application {

    private val inputView = InputView()
    private val resultView = ResultView()
    private val lottoGenerator = LottoGenerator(NumberGenerator())

    fun run() {
        val inputPayment = inputView.inputPayment()
        val lottoCount = Lotto.calculateLottoCount(inputPayment)
        val lottoList = lottoGenerator.generate(lottoCount)

        resultView.printLotto(lottoList)

        val inputLuckyNumbers = inputView.inputLuckyNumbers()
        val lottoResult = LottoResultService.inquireResult(inputLuckyNumbers, lottoList)
        val statisticsResult = LottoStatistics.statistics(inputPayment, lottoResult)

        resultView.printLottoStatistics(statisticsResult)
    }
}
