package lotto.domain

import lotto.exception.IllegalPurchaseException

@JvmInline
value class Purchase(val purchasePrice: Int) {
    init {
        if (purchasePrice < 0) {
            throw IllegalPurchaseException()
        }
    }

    fun calculateQuantity(): Int {
        return purchasePrice / LOTTO_PRICE
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
