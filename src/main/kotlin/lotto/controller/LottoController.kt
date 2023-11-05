package lotto.controller

import lotto.model.LottoInfo
import lotto.ui.InputView
import lotto.ui.ResultView

class LottoController(
    private val inputPurchaseAmount: String,
) {

    fun countCorrectNumberCount(generatedLottoInfo: LottoInfo, latestWinLottoInfo: LottoInfo): Int {
        val diff = (generatedLottoInfo.numbers.toSet() - latestWinLottoInfo.numbers.toSet()).size
        return LOTTO_NUMBER_COUNT - diff
    }

    fun generateMultipleLottoNumbers(): List<LottoInfo> {
        val lottoInfoList = mutableListOf<LottoInfo>()
        repeat(getPaidLottoCount()) {
            lottoInfoList.add(LottoInfo(getRandomGeneratedNumbers()))
        }
        return lottoInfoList
    }

    fun getPaidLottoCount() = getValidatePurchaseAmount() / PURCHASE_AMOUNT_UNIT

    fun getValidatePurchaseAmount(): Int {
        return run {
            val amount = inputPurchaseAmount.toInt()
            require(isValidAmount(amount)) {
                "구매 금액은 최소 1000원이며, 1000원 단위로 입력되어야 합니다."
            }
            amount
        }
    }

    fun getRandomGeneratedNumbers(): List<Int> {
        return getRandomLottoNumbers().sorted()
    }

    private fun getRandomLottoNumbers() = (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).shuffled().take(LOTTO_NUMBER_COUNT)

    private fun isValidAmount(amount: Int) = amount >= MINIMUM_PURCHASE_AMOUNT && amount % PURCHASE_AMOUNT_UNIT == 0

    companion object {
        private const val MINIMUM_PURCHASE_AMOUNT = 1000
        private const val PURCHASE_AMOUNT_UNIT = 1000

        const val LOTTO_NUMBER_COUNT = 6
        private const val MAX_LOTTO_NUMBER = 45
        private const val MIN_LOTTO_NUMBER = 1
    }
}

fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()
    val generatedLottoInfos = LottoController(purchaseAmount).generateMultipleLottoNumbers()
    ResultView.showGeneratedLottoInfos(generatedLottoInfos)

    val latestWinInfo = InputView.getLatestWinInfo()
}
