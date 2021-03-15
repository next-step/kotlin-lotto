package domain

import domain.Lottery.Companion.DEFAULT_LOTTO_PRICE

class LotteryFactory(val inputPrice: Int, val unitPrice: Int = DEFAULT_LOTTO_PRICE) {
    fun calculateLotteryCountByPrice(): Int {
        return inputPrice / unitPrice
    }
}
