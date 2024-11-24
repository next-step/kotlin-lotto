package lotto.infrastructure

import lotto.adapter.LottoInputAdapter
import lotto.domain.LottoPurchaseAmount

class ConsoleLottoInputAdapter(private val inputView: lotto.view.InputView) : LottoInputAdapter {
    override fun fetchPurchaseAmount(): LottoPurchaseAmount {
        val purchaseInput = inputView.inputPurchaseAmount()
        return LottoPurchaseAmount(purchaseInput.toInt())
    }

    override fun fetchWinningNumbers(): List<Int> {
        val winningLineInput = inputView.inputWinningNumbers()
        return winningLineInput.split(",").map { it.trim().toInt() }
    }
}
