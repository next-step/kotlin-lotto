package lotto.sixFortyFiveNumberLotto

import lotto.LottoStore
import lotto.sixFortyFiveNumberLotto.purchase.SixFortyFiveLottoPurchases

class SixFortyFiveLottoStore : LottoStore<SixFortyFiveLottoPurchases, SixFortyFiveLottoes> {
    override fun purchase(purchases: SixFortyFiveLottoPurchases): SixFortyFiveLottoes {
        return purchases.value.map { SixFortyFiveLotto(it.getNumbers()) }.toLottoes()
    }

    fun getAutoPurchaseCount(
        price: SixFortyFiveLottoPurchasePrice,
        manualPurchaseCount: SixFortyFiveLottoCount,
    ): SixFortyFiveLottoCount {
        val value = (price.value / SixFortyFiveLotto.LOTTO_PRICE) - manualPurchaseCount.value
        return SixFortyFiveLottoCount(value)
    }
}
