package lotto.domain

class Cashier {
    companion object {
        private const val LOTTO_PRICE = 1000

        fun purchaseLotto(amount: Int): Int {
            require(amount >= LOTTO_PRICE)
            return amount / LOTTO_PRICE
        }

        fun exchange() {
        }
    }
}
