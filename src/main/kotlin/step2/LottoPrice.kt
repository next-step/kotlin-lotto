package step2

object LottoPrice {
    fun getCountFrom(money: Int): Int {
        return money / PRICE_PER_LOTTO
    }

    const val PRICE_PER_LOTTO = 1000
}
