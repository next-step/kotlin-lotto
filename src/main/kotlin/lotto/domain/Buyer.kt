package lotto.domain

class Buyer(price: Int = 0) {

    val purchaseCount: Int

    init {
        val lottoPrice = 1000
        purchaseCount = price / lottoPrice
    }
}
