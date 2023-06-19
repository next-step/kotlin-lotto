package lotto.sixFortyFiveNumberLotto

import lotto.LottoStore

class SixFortyFiveLottoStore : LottoStore<SixFortyFiveLotto, SixFortyFiveLottoWinningNumber> {
    override fun purchase(count: Int): List<SixFortyFiveLotto> {
        return (1..count).map { makeLotto() }
    }

    override fun makeLotto(): SixFortyFiveLotto {
        val numbers = SixFortyFiveLottoNumber.of()
        return SixFortyFiveLotto(numbers)
    }

    fun getPurchaseCountByPrice(price: Int): Int {
        return price / SixFortyFiveLotto.LOTTO_PRICE
    }
}
