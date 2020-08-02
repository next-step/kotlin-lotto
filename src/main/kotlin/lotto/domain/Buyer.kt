package lotto.domain

class Buyer(val price: Int) {

    val purchaseCount: Int

    init {
        val lottoPrice = 1000
        purchaseCount = price / lottoPrice
    }
}
