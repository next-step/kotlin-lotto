package lotto

import lotto.domain.Lotto
import lotto.domain.Money
import lotto.service.LottoService
import lotto.view.InputView
import lotto.view.ResultView

class LottoController() {
    private val purchaseAmount: Money = buyLotto()
    fun run() {
        val manualLottos = getManualLottos()
        val lottos = getGeneratedLottos()

        getLottoResults(manualLottos, lottos)
    }

    private fun buyLotto(): Money {
        return InputView.getPurchaseAmount()
    }

    private fun getManualLottos(): List<Lotto> {
        return InputView.getManaulLottos(purchaseAmount)
    }

    private fun getGeneratedLottos(): List<Lotto> {
        return LottoService.generateLottos(purchaseAmount)
    }

    private fun getLottoResults(manualLottos: List<Lotto>, generatedLottos: List<Lotto>) {
        ResultView.printLottoList(manualLottos, generatedLottos)
            .let { lottos ->
                val winningLotto = InputView.getWinningNumbers()
                val result = LottoService.getLottoResult(lottos, winningLotto)
                ResultView.outputResult(purchaseAmount, result)
            }
    }
}
