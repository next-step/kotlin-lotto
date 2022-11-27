package lotto.application

import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import lotto.domain.LottoResultRequest
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
        val statistics = LottoResultService.inquireStatistics(
            toLottoResultRequest(inputPayment, inputLuckyNumbers, lottoList)
        )
        resultView.printLottoStatistics(statistics)
    }

    private fun toLottoResultRequest(
        inputPayment: Int,
        inputLuckyNumbers: List<Int>,
        lottoList: List<Lotto>
    ) = LottoResultRequest(
        payment = inputPayment,
        luckyNumbers = inputLuckyNumbers,
        lottoList = lottoList
    )
}
