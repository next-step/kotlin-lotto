package lotto

import lotto.view.InputView
import lotto.view.OutputView

class LottoGame(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    fun run() {
        val money = inputView.receiveMoney()
        val lottos = LottoShop.sellLottos(money)
        outputView.showPurchased(lottos)

        val winningNumbers = inputView.receiveWinningNumbers()
        val result = lottos.playWith(winningNumbers)
        outputView.show(result)
    }
}
