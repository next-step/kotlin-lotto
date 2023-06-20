package lotto.controller

import lotto.domain.LottoGenerator
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.LottoStatistics
import lotto.domain.Lottos
import lotto.domain.Payment
import lotto.domain.Rank
import lotto.domain.WinningNumber
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val lottoGenerator: LottoGenerator,
    private val lottoStatistics: LottoStatistics
) {

    fun start() {
        val inputPayment = inputPayment()
        val lottos = purchaseLottos(inputPayment)
        val lastWinningNumbers = inputWinningNumbersLastWeek()
        val bonusBall = inputBonusBall()
        val winningNumber = WinningNumber(lastWinningNumbers, bonusBall)

        val result = getStatisticsAccordingToBonus(lottos, winningNumber)
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

    private fun inputWinningNumbersLastWeek(): LottoNumbers {
        OutputView.printWinningNumbersLastWeek()
        return LottoNumbers(InputView.inputWinnerNumbers())
    }

    private fun inputBonusBall(): LottoNumber {
        OutputView.printBonusBall()
        val inputBonusBall = InputView.inputBonusBall()
        return LottoNumber(inputBonusBall)
    }

    private fun getStatisticsAccordingToBonus(
        lottos: Lottos,
        winningNumber: WinningNumber
    ): List<Rank> {
        OutputView.printWinnerStatistics()
        val result = lottoStatistics.analyze(lottos, winningNumber)
        OutputView.printStatisticsAccordingToBonus(result)
        return result
    }

    private fun calculateProfitRate(inputPayment: Int, result: List<Rank>) {
        val profitRate = lottoStatistics.getProfitRate(Payment(inputPayment), result)
        OutputView.printProfitRate(profitRate)
    }
}
