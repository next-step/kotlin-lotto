package lotto.domain

data class Cashier(private val amount: Int) {
    fun purchaseLotto(): Int {
        require(amount >= LOTTO_PRICE)
        return amount / LOTTO_PRICE
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
