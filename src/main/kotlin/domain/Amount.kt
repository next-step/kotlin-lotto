package domain

const val LOTTO_PRICE = 1000

data class Amount(val amount: Int) {

    fun calculatePurchaseLottoCount() = amount / LOTTO_PRICE

    fun calculateChange() = amount % LOTTO_PRICE
}
