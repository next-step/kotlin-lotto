package lotto.sixFortyFiveNumberLotto

import lotto.LottoStore

class SixFortyFiveLottoStore : LottoStore<SixFortyFiveLottoPurchases, SixFortyFiveLottoes> {
    override fun purchase(purchases: SixFortyFiveLottoPurchases): SixFortyFiveLottoes {
        return SixFortyFiveLottoes(purchases.value.map { SixFortyFiveLotto.from(it) })
    }

    fun getPurchaseCountByPrice(price: SixFortyFiveLottoPurchasePrice): SixFortyFiveLottoCount {
        return SixFortyFiveLottoCount(price.value / SixFortyFiveLotto.LOTTO_PRICE)
    }
}
