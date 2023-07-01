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
        val lottos = lottoManager.buyLotto(price)
        outputView.printLottos(lottos)

        val winningNumbers = inputView.readWinningAndBonusNumbers()
        val result = lottoManager.getResult(lottos, winningNumbers)
        outputView.printLottoResult(result)
    }
}
