package lotto

class SixFortyFiveLottoStore : LottoStore {
    override fun purchase(count: Int): List<SixFortyFiveLotto> {
        return (1..count).map { makeLotto() }
    }

    override fun makeLotto(): SixFortyFiveLotto {
        return SixFortyFiveLotto()
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
