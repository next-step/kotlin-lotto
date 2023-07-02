package lotto

import lotto.ui.InputView
import lotto.ui.OutputView

class LottoController(
    private val lottoManager: LottoManager,
    private val outputView: OutputView,
    private val inputView: InputView,
) {

    fun execute() {
        val price = inputView.readPrice()
        val manualLottoCount = inputView.readManualLottoCount(price)
        val manualLottoNumbers = inputView.readManualLottoNumbers(manualLottoCount)
        val lottos = lottoManager.buyLottos(manualLottoCount, manualLottoNumbers)
        outputView.printLottos(lottos)

        val winningNumbers = inputView.readWinningAndBonusNumbers()
        val result = lottoManager.getResult(lottos, winningNumbers)
        outputView.printLottoResult(result)
    }
}
