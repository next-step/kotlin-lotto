package lotto

class SixFortyFiveLottoStore : LottoStore {
    override fun purchase(count: Int): List<Lotto> {
        return (1..count).map { makeLotto() }
    }
    override fun makeLotto(): Lotto {
        return SixFortyFiveLotto()
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
