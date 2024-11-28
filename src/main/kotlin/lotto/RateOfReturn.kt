package lotto

import lotto.LotteryTicketMachine.Companion.TICKET_PRICE
import kotlin.math.floor
import kotlin.math.pow

class RateOfReturn(totalWinningAmount: Money, totalCost: Money) {
    private val value = totalWinningAmount.toDouble() / totalCost.toDouble()

    init {
        require(totalCost >= TICKET_PRICE) {
            "총 비용은 로또 1장 구매 가격(${TICKET_PRICE.toLong()}원)보다 같거나 커야 한다"
        }
    }

    fun toDouble(scale: Int = DEFAULT_SCALE): Double {
        val factor = 10.0.pow(scale)
        return floor(value * factor) / factor
    }

    companion object {
        private const val DEFAULT_SCALE = 2
        const val BASE_RATE_OF_RETURN = 1
    }
}
