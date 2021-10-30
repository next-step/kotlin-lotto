package lotto.domain

import lotto.exception.IllegalPurchaseException

@JvmInline
value class Purchase(val purchasePrice: Int) {
    init {
        if (purchasePrice < 0) {
            throw IllegalPurchaseException()
        }
    }

    fun calculateQuantity(lottoPrice: Int): Int {
        return purchasePrice / lottoPrice
    }
}
