package lotto.domain

import java.math.BigDecimal
import java.math.BigInteger
import java.text.NumberFormat

data class Money(val won: BigInteger) {
    init {
        if (won < BigInteger.ZERO) {
            throw IllegalArgumentException(INVALID_MONEY_MESSAGE)
        }
    }

    constructor(won: Int) : this(won.toBigInteger())

    operator fun plus(money: Money) = Money(won + money.won)

    operator fun times(count: Int) = Money(won * count.toBigInteger())

    operator fun div(count: Double) = won.toBigDecimal().div(count.toBigDecimal())

    operator fun div(count: Int) = won.div(count.toBigInteger())

    operator fun div(count: BigDecimal): BigDecimal = won.toBigDecimal().divide(count)

    override fun toString(): String {
        return "${numberInstance.format(won)}원"
    }

    fun toBigDecimal() = won.toBigDecimal()

    companion object {
        private val numberInstance = NumberFormat.getNumberInstance()
        private const val INVALID_MONEY_MESSAGE = "음수는 Money로 사용될 수 없습니다."
    }
}
