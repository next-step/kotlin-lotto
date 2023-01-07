package lottery.service

import kotlin.math.floor

class ExchangeService {
    fun calculateQuantity(amount: Long): Int {
        check(amount > LOTTO_PRICE)
        return floor(amount.toDouble().div(LOTTO_PRICE)).toInt()
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}