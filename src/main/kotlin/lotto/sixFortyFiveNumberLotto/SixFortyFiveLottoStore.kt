package lotto.sixFortyFiveNumberLotto

import lotto.LottoStore
import lotto.sixFortyFiveNumberLotto.purchase.SixFortyFiveAutoLottoPurchase
import lotto.sixFortyFiveNumberLotto.purchase.SixFortyFiveManualLottoPurchase
import lotto.sixFortyFiveNumberLotto.purchase.SixFortyFiveLottoPurchases

class SixFortyFiveLottoStore : LottoStore<SixFortyFiveLottoPurchases, SixFortyFiveLottoes> {
    override fun purchase(purchases: SixFortyFiveLottoPurchases): SixFortyFiveLottoes {
        return purchases.value.map { purchase ->
            when (purchase) {
                is SixFortyFiveManualLottoPurchase -> purchaseOfManual(purchase)
                is SixFortyFiveAutoLottoPurchase -> purchaseOfAuto()
            }
        }.toLottoes()
    }

    private fun purchaseOfManual(purchase: SixFortyFiveManualLottoPurchase): SixFortyFiveLotto {
        return SixFortyFiveLotto(purchase.numbers)
    }

    private fun purchaseOfAuto(): SixFortyFiveLotto {
        return SixFortyFiveLotto.ofAuto()
    }

    fun getAutoPurchaseCount(
        price: SixFortyFiveLottoPurchasePrice,
        manualPurchaseCount: SixFortyFiveLottoCount,
    ): SixFortyFiveLottoCount {
        val value = (price.value / SixFortyFiveLotto.LOTTO_PRICE) - manualPurchaseCount.value
        return SixFortyFiveLottoCount(value)
    }
}
