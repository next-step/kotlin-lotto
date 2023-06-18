package lotto.controller

import lotto.domain.LottoGenerator
import lotto.domain.LottoNumber
import lotto.domain.LottoStatistics
import lotto.domain.Lottos
import lotto.domain.Payment
import lotto.domain.Rank
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val lottoGenerator: LottoGenerator,
    private val lottoStatistics: LottoStatistics
) {

    fun start() {
        val inputPayment = inputPayment()
        val lottos = purchaseLottos(inputPayment)
        val winnerNumbers = inputWinningNumbersLastWeek()
        val result = getNumberOfMatches(lottos, winnerNumbers)
        calculateProfitRate(inputPayment, result)
    }

    private fun inputPayment(): Int {
        OutputView.printEnterPayment()
        return InputView.inputPayment()
    }

    private fun purchaseLottos(inputPayment: Int): Lottos {
        val lottoCount = lottoGenerator.getLottoCount(inputPayment)
        OutputView.printPurchaseCount(lottoCount)

        val lottos = lottoGenerator.generateLottos(lottoCount)
        OutputView.printLottos(lottos)
        return lottos
    }

    private fun inputWinningNumbersLastWeek(): List<LottoNumber> {
        OutputView.printWinningNumbersLastWeek()
        return InputView.inputWinnerNumbers()
    }

    private fun getNumberOfMatches(
        lottos: Lottos,
        winnerNumbers: List<LottoNumber>
    ): List<Rank> {
        OutputView.printWinnerStatistics()
        val result = lottoStatistics.analyze(lottos, winnerNumbers)
        OutputView.printNumberOfMatches(result)
        return result
    }

    private fun calculateProfitRate(inputPayment: Int, result: List<Rank>) {
        val profitRate = lottoStatistics.getProfitRate(Payment(inputPayment), result)
        OutputView.printProfitRate(profitRate)
    }
}
