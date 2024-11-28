package lotto.domain

class Cashier {
    companion object {
        fun purchaseLotto(amount: Int): Int {
            require(amount >= LOTTO_PRICE)
            return amount / LOTTO_PRICE
        }

        private const val LOTTO_PRICE = 1000
    }
}
