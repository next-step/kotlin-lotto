package domain

const val LOTTO_PRICE = 1000L

data class Amount(val amount: Long) {

    fun calculatePurchaseLottoCount() = amount / LOTTO_PRICE

    fun calculateChange() = amount % LOTTO_PRICE
}
