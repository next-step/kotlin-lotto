package lotto.infrastructure

import lotto.adapter.LottoInputAdapter
import lotto.domain.LottoBall
import lotto.domain.LottoBalls
import lotto.domain.LottoPurchaseAmount
import lotto.view.InputView

class ConsoleLottoInputAdapter(private val inputView: InputView) : LottoInputAdapter {
    override fun fetchPurchaseAmount(): LottoPurchaseAmount {
        val purchaseInput = inputView.inputPurchaseAmount()
        return LottoPurchaseAmount(purchaseInput.toInt())
    }

    override fun fetchWinningNumbers(): LottoBalls {
        val winningLineInput = inputView.inputWinningNumbers()
        val numbers =
            winningLineInput.split(",")
                .map { LottoBall(it.trim().toInt()) }
        return LottoBalls(numbers)
    }

    override fun fetchBonusNumber(): LottoBall {
        val bonusNumberInput = inputView.inputBonusNumber()
        return LottoBall(bonusNumberInput.toInt())
    }
}
