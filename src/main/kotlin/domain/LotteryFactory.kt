package domain

import domain.Lottery.Companion.DEFAULT_LOTTO_PRICE

class LotteryFactory(private val inputPrice: Int, private val unitPrice: Int = DEFAULT_LOTTO_PRICE) {
    init {
        require(unitPrice in DEFAULT_LOTTO_PRICE until inputPrice) { "잘못된 금액을 입력하였습니다." }
    }

    fun calculateLotteryCountByPrice(): Int {
        return inputPrice / unitPrice
    }
}
