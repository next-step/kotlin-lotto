package lotto

import lotto.view.InputView
import lotto.view.OutputView

class LottoGame(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    fun run(purchaseCommand: LottoPurchaseCommand = RandomPurchaseCommand) {
        val money = inputView.receiveMoney()
        val lottos = LottoShop.sell(money, purchaseCommand)
        outputView.showPurchased(lottos)

        val winningNumbers = inputView.receiveWinningNumbers()
        val result = lottos.playWith(winningNumbers)
        outputView.show(result)
    }
}
