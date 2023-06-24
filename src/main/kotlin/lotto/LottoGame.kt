package lotto

import lotto.view.InputView
import lotto.view.OutputView

class LottoGame(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val lottoShop: LottoShop,
) {
    fun run() {
        val money = inputView.receiveMoney()
        val purchaseCommand = inputView.receivePurchaseCommand()
        val lottos = lottoShop.sell(money, purchaseCommand)
        outputView.showPurchased(lottos)

        val winningNumbers = inputView.receiveWinningNumbers()
        val result = lottos.playWith(winningNumbers)
        outputView.show(result)
    }
}
