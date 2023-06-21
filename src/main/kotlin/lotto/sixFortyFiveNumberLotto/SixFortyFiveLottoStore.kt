package lotto.sixFortyFiveNumberLotto

import lotto.LottoStore

class SixFortyFiveLottoStore : LottoStore<SixFortyFiveLotto> {
    override fun purchase(count: Int): List<SixFortyFiveLotto> {
        return (1..count).map { SixFortyFiveLotto.of() }
    }

    fun getPurchaseCountByPrice(price: Int): Int {
        return price / SixFortyFiveLotto.LOTTO_PRICE
    }
}
