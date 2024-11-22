package lotto.domain

import java.math.BigInteger

class Payment(
    val amount: BigInteger,
) {
    val numberOfLines: Int
        get() = (amount / PRICE_PER_LINE).toInt()

    init {
        require(amount > BigInteger.ZERO) { "금액은 0 이상이어야 합니다." }
        require(amount % PRICE_PER_LINE == BigInteger.ZERO) { "금액은 1000원 단위여야 합니다." }
    }

    fun doubleValue(): Double = amount.toDouble()

    companion object {
        val PRICE_PER_LINE: BigInteger = BigInteger.valueOf(1000)

        fun from(amount: Long): Payment = Payment(BigInteger.valueOf(amount))
    }
}
