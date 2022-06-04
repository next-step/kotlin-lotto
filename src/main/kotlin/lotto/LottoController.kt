package lotto

import lotto.model.LottoResult
import lotto.model.LottoStore
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun startGame() {
        val price = inputView.getBuyingPrice()
        val lottoStore = LottoStore()
        val lottoList = lottoStore.buy(price)
        outputView.showBuyingHistory(lottoList)

        val winningNumbers = inputView.inputLastWinningNumbers()

        outputView.showMatchStatistics(
            lottoResult = LottoResult.of(lottoList, winningNumbers)
        )
    }
}
