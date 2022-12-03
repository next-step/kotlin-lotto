package lotto.controller

import lotto.application.LottoStatisticsService
import lotto.domain.LottoGenerator
import lotto.domain.LottoShop
import lotto.domain.RandomNumberGenerator
import lotto.view.InputView
import lotto.view.ResultView

class LottoController(
    private val lottoStatisticsService: LottoStatisticsService
) {

    private val lottoShop = LottoShop(LottoGenerator(RandomNumberGenerator()))

    fun start() {
        val inputPayment = InputView.inputPayment()
        val lottoList = lottoShop.buy(inputPayment)
        ResultView.printLotto(lottoList)

        val luckNumbers = InputView.inputLuckyNumbers()
        val statistics = lottoStatisticsService.statistics(luckNumbers, lottoList, inputPayment)
        ResultView.printLottoStatistics(statistics)
    }
}
