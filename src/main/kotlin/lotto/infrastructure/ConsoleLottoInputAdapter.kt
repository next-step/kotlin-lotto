package lotto.infrastructure

import lotto.adapter.LottoInputAdapter
import lotto.domain.LottoBall
import lotto.domain.LottoBalls
import lotto.domain.LottoLine
import lotto.domain.LottoPurchaseAmount
import lotto.domain.LottoPurchaseCount
import lotto.view.InputView

class ConsoleLottoInputAdapter(private val inputView: InputView) : LottoInputAdapter {
    override fun fetchPurchaseAmount(): LottoPurchaseAmount {
        val purchaseInput = inputView.inputPurchaseAmount()
        return LottoPurchaseAmount(purchaseInput.toInt())
    }

    override fun fetchManualPurchaseCount(): LottoPurchaseCount {
        val manualPurchaseCount = inputView.inputManualPurchaseCount()
        return LottoPurchaseCount(manualPurchaseCount.toInt())
    }

    override fun fetchManualLines(manualPurchaseCount: LottoPurchaseCount): List<LottoLine> {
        val manualNumbers = inputView.inputManualNumbers(manualPurchaseCount)
        return manualNumbers.map {
            LottoLine(makeLottoBalls(it))
        }
    }

    override fun fetchWinningNumbers(): LottoBalls {
        val winningLineInput = inputView.inputWinningNumbers()
        return makeLottoBalls(winningLineInput)
    }

    private fun makeLottoBalls(winningLineInput: String): LottoBalls {
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
