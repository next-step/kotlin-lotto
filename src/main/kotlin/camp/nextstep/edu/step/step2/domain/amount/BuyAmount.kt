package camp.nextstep.edu.step.step2.domain.amount

import java.math.BigDecimal

@JvmInline
value class BuyAmount(
    val amount: BigDecimal
) {
    init {
        require(amount > BigDecimal.ZERO) { "구매 금액은 0보다 커야 합니다." }
    }

    constructor(amount: Long) : this(BigDecimal.valueOf(amount))

    fun divideByLotteryPrice(ticketPrice: Long): Int {
        return amount.divide(BigDecimal.valueOf(ticketPrice)).toInt()
    }

}
