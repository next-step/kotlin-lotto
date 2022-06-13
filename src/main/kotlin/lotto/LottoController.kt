package lotto

import lotto.model.LottoResult
import lotto.model.LottoStore
import lotto.model.WinningLotto
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun startGame() {
        val price = inputView.getBuyingPrice()
        val manualLottoCount = inputView.getManualLottoCount()
        val manualLottos = inputView.createManualLotto(manualLottoCount)

        val lottoStore = LottoStore()
        val lottos = lottoStore.buy(price - (manualLottoCount * 1000), manualLottos)
        outputView.showBuyingHistory(manualLottoCount, lottos)

        val winningNumbers = inputView.inputLastWinningNumbers()
        val bonusNumber = inputView.inputBonusNumber()
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)

        outputView.showMatchStatistics(
            lottoResult = LottoResult.of(lottos, winningLotto)
        )
    }
}
