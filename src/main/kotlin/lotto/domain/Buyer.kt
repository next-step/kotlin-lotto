package lotto.domain

class Buyer(price: Int = 0) {

    val purchaseCount: Int

    init {
        purchaseCount = price / LOTTO_PRICE
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
