package lotto.domain.value

import java.math.BigDecimal
import java.math.BigInteger

data class Money(private val won: BigInteger) {
    init {
        if (won < BigInteger.ZERO) throw IllegalArgumentException("음수는 Money로 사용될 수 없습니다.")
    }

    operator fun plus(money: Money) = Money(won.plus(money.won))

    operator fun times(count: Int) = Money(won * count.toBigInteger())

    operator fun div(count: Double) = won.toBigDecimal().div(count.toBigDecimal())

    operator fun div(count: Int) = won.div(count.toBigInteger())

    operator fun div(count: BigDecimal) = won.toBigDecimal().div(count)

    override fun toString() = "${won}원"

    fun toDouble(): Double {
        return won.toDouble()
    }
}
