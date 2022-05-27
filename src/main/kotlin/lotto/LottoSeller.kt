package lotto

class LottoSeller(private val money: Money) {

    fun getLottoCount(): Int {
        return money.divide(LOTTO_PRICE).get
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
