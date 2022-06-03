package lotto

class LottoStore {

    fun buy(money: Int): Int {
        return money / LOTTO_PRICE
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
