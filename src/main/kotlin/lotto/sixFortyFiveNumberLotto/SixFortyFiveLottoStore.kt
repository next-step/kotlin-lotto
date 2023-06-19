package lotto.sixFortyFiveNumberLotto

import lotto.LottoStore

class SixFortyFiveLottoStore : LottoStore<SixFortyFiveLotto, SixFortyFiveWinningLotto> {
    override fun purchase(count: Int): List<SixFortyFiveLotto> {
        return (1..count).map { makeLotto() }
    }

    override fun makeLotto(): SixFortyFiveLotto {
        return SixFortyFiveLotto.of()
    }

    fun getPurchaseCountByPrice(price: Int): Int {
        return price / SixFortyFiveLotto.LOTTO_PRICE
    }
}
