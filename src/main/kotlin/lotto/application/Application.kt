package lotto.application

import lotto.domain.LottoGenerator
import lotto.domain.LottoResultService
import lotto.domain.LottoShop
import lotto.util.RandomNumberGenerator
import lotto.view.InputView
import lotto.view.ResultView

class Application {
    private val inputView = InputView()
    private val resultView = ResultView()
    private val lottoShop = LottoShop(LottoGenerator(RandomNumberGenerator()))

    fun run() {
        val inputPayment = inputView.inputPayment()
        val lottoList = lottoShop.buyLotto(inputPayment)
        resultView.printLotto(lottoList)

        val inputLuckyNumbers = inputView.inputLuckyNumbers()
        val lottoResultService = LottoResultService(inputLuckyNumbers)
        val statistics = lottoResultService.inquireStatistics(inputPayment, lottoList)
        resultView.printLottoStatistics(statistics)
    }
}
