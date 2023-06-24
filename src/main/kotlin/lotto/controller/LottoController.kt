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
        return InputView.inputNumber()
    }

    private fun purchaseLottos(inputPayment: Int): Lottos {
        val manualLottoCount = inputManualLottoCount()
        val lottoCount = lottoGenerator.getLottoCount(inputPayment)
        require(lottoCount >= manualLottoCount) { "수동 구매 로또 수가 구입 금액을 초과하였습니다." }

        val manualLottos = generateManualLottos(manualLottoCount)

        OutputView.printPurchaseCount(manualLottoCount, lottoCount)
        val lottos = lottoGenerator.generateLottos(lottoCount, manualLottos)
        OutputView.printLottos(lottos)
        return lottos
    }

    private fun inputManualLottoCount(): Int {
        OutputView.printEnterManualLottoCount()
        return InputView.inputNumber()
    }

    private fun generateManualLottos(manualLottoCount: Int): MutableList<LottoNumbers> {
        OutputView.printEnterManualLottoNumbers()
        val manualLottos = mutableListOf<LottoNumbers>()
        repeat(manualLottoCount) {
            val lottoNumbers = LottoNumbers(InputView.inputLottoNumbers())
            manualLottos.add(lottoNumbers)
        }
        return manualLottos
    }

    private fun inputWinningNumbersLastWeek(): LottoNumbers {
        OutputView.printWinningNumbersLastWeek()
        return LottoNumbers(InputView.inputLottoNumbers())
    }

    private fun inputBonusBall(): LottoNumber {
        OutputView.printBonusBall()
        val inputBonusBall = InputView.inputNumber()
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
