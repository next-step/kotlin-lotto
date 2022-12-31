package lotto.domain

class BuyPrice(
    private val price: Int
) {

    fun getLottoCount() = price / LOTTO_PRICE

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
