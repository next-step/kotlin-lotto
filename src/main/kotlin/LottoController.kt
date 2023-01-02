import UI.InputView
import UI.OutputView
import domain.LottoInput
import domain.WinningLotto
import service.AutoNumberGenerator
import service.CalculateWinningStatistic
import service.RandomNumberGenerator
import service.WinningNumberRegister

class LottoController {
    fun start() {
        val inputView = InputView
        val outputView = OutputView

        val lottoInput = inputView.purchaseInputView()
        outputView.ticketCountView(lottoInput.purchaseCount!!)

        val randomNumberGenerator = RandomNumberGenerator(1, 45)
        val autoNumberGenerator = AutoNumberGenerator(randomNumberGenerator)
        val generatedLottos = autoNumberGenerator.saveAfterGenerate(lottoInput.purchaseCount)
        outputView.purchaseLottoView(generatedLottos)

        val winning = inputView.winningLottoInputView()
        lottoInput.of(LottoInput(winningLotto = winning))

        val winningNumberRegister = WinningNumberRegister(randomNumberGenerator)
        val winningLotto = winningNumberRegister.register(lottoInput)

        outputView.statisticDividerView()

        val calculateWinningStatistic = CalculateWinningStatistic()
        val ranks = calculateWinningStatistic.calculateRank(generatedLottos, winningLotto)
        //output ranks statisticPrizeView
        val prize = calculateWinningStatistic.calculatePrize(ranks)
        val rate = calculateWinningStatistic.calculateRate(prize, lottoInput.purchaseAmount!!)
        outputView.statisticRateView(rate)


    }
}

fun main() {
    LottoController().start()
}