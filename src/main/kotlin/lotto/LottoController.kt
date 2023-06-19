package lotto

import lotto.domain.Lotto
import lotto.domain.LottoMachine
import lotto.domain.LottoResult
import lotto.domain.LottoWinningNumbers
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    fun execute() {
        val lottos = getLottos()
        OutputView.printLottos(lottos)

        val lottoResult = getLottoResult(lottos)
        val profitRate = lottoResult.getProfitRate(LottoMachine.LOTTO_PRICE)
        OutputView.printLottoRankStatics(lottoResult.getLottoRankStatistic())
        OutputView.printProfitRate(profitRate)
    }

    private fun getLottos(): List<Lotto> {
        val purchaseAmount = InputView.getPurchaseAmount()
        val lottos = LottoMachine.getLottos(purchaseAmount)
        return lottos
    }

    private fun getLottoResult(lottos: List<Lotto>): LottoResult {
        val winningNumbers = InputView.getWinningNumbers()
        val bonusNumber = InputView.getBonusNumber()
        return LottoWinningNumbers(winningNumbers, bonusNumber).getLottoResult(lottos)
    }
}

fun main() {
    LottoController().execute()
}
