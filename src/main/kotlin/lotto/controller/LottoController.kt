package lotto.controller

import lotto.domain.*
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

        calculateStatisticsAccordingToBonus(lottos, winningNumber)
        calculateProfitRate(inputPayment)
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

    private fun generateManualLottos(manualLottoCount: Int): Lottos {
        OutputView.printEnterManualLottoNumbers()
        val manualLottos = mutableListOf<Lotto>()
        repeat(manualLottoCount) {
            val lotto = Lotto(InputView.inputLottoNumbers())
            manualLottos.add(lotto)
        }
        return Lottos(manualLottos)
    }

    private fun inputWinningNumbersLastWeek(): Lotto {
        OutputView.printWinningNumbersLastWeek()
        return Lotto(InputView.inputLottoNumbers())
    }

    private fun inputBonusBall(): LottoNumber {
        OutputView.printBonusBall()
        val inputBonusBall = InputView.inputNumber()
        return LottoNumber(inputBonusBall)
    }

    private fun calculateStatisticsAccordingToBonus(
        lottos: Lottos,
        winningNumber: WinningNumber
    ): RankFactory {
        OutputView.printWinnerStatistics()
        val rankFactory = lottoStatistics.analyze(lottos, winningNumber)
        OutputView.printStatisticsAccordingToBonus(rankFactory)
        return rankFactory
    }

    private fun calculateProfitRate(inputPayment: Int) {
        val profitRate = lottoStatistics.getProfitRate(Payment(inputPayment))
        OutputView.printProfitRate(profitRate)
    }
}
