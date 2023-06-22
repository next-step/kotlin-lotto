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
        val profitRate = lottoResult.getProfitRate(LottoPurchaseMachine.LOTTO_PRICE)
        OutputView.printLottoRankStatics(lottoResult.getLottoRankStatistic())
        OutputView.printProfitRate(profitRate)
    }

    private fun getLottos(): List<Lotto> {
        val purchaseAmount = InputView.getPurchaseAmount()
        val lottos = LottoPurchaseMachine.getLottos(purchaseAmount)
        return lottos
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
