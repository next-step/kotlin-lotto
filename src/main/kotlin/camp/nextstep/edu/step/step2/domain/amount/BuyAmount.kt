package camp.nextstep.edu.step.step2.domain.amount

import java.math.BigDecimal

@JvmInline
value class BuyAmount(
    private val amount: BigDecimal
) {
    init {
        require(amount > BigDecimal.ZERO) { "구매 금액은 0보다 커야 합니다." }
    }

    fun getAmount(): BigDecimal {
        return amount
    }

    companion object {
        fun of(amount: Long): BuyAmount {
            return BuyAmount(BigDecimal.valueOf(amount))
        }
    }

}
