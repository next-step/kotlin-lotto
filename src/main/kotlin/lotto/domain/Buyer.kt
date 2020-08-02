package lotto.domain

class Buyer(val price: Int) {

    val perchaseCount: Int

    init {
        val lottoPrice = 1000
        perchaseCount = price / lottoPrice
    }
}
