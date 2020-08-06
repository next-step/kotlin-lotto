package lotto.domain

const val LOTTO_PRICE = 1000

class Buyer(price: Int = 0) {
    val purchaseCount: Int = price / LOTTO_PRICE
}
