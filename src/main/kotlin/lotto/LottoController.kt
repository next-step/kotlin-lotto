package lotto

import lotto.domain.Lotto
import lotto.domain.LottoPurchaseMachine
import lotto.domain.LottoWinningNumbers
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    fun execute() {
        val lottos = getLottos()
        OutputView.printLottos(lottos)

        val lottoWinningNumbers = getLottoWinningNumbers()
        val lottoResult = lottoWinningNumbers.getLottoResult(lottos)
        val lottoRankStatistic = lottoResult.getLottoRankStatistic()
        val profitRate = lottoResult.getProfitRate(LottoPurchaseMachine.LOTTO_PRICE)
        OutputView.printLottoRankStatics(lottoRankStatistic)
        OutputView.printProfitRate(profitRate)
    }

    private fun getLottos(): List<Lotto> {
        val purchaseAmount = InputView.getPurchaseAmount()
        val numberOfManualLotto = InputView.getNumberOfManualLotto()
        val manualLottos = InputView.getManualLottos(numberOfManualLotto)
        val lottos = LottoPurchaseMachine.getLottos(purchaseAmount, manualLottos)
        printNumberOfLotto(lottos.size, numberOfManualLotto)
        return lottos
    }

    private fun printNumberOfLotto(totalNumberOfLotto: Int, manualNumberOfLotto: Int) {
        val autoLottoCount = totalNumberOfLotto - manualNumberOfLotto
        OutputView.printNumberOfLotto(manualNumberOfLotto, autoLottoCount)
    }

    private fun getLottoWinningNumbers(): LottoWinningNumbers {
        val winningNumbers = InputView.getWinningNumbers()
        val bonusNumber = InputView.getBonusNumber()
        return LottoWinningNumbers.of(winningNumbers, bonusNumber)
    }
}

fun main() {
    LottoController().execute()
}
