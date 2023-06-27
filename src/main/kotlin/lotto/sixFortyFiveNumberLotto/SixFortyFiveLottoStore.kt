package lotto.sixFortyFiveNumberLotto

import lotto.LottoStore

class SixFortyFiveLottoStore : LottoStore<SixFortyFiveLottoes> {
    override fun purchase(count: Int): SixFortyFiveLottoes {
        return SixFortyFiveLottoes((1..count).map { SixFortyFiveLotto.of() })
    }

    fun getPurchaseCountByPrice(price: Int): Int {
        return price / SixFortyFiveLotto.LOTTO_PRICE
    }
}
