package lotto.domain

import java.math.BigDecimal
import java.math.BigInteger
import java.math.RoundingMode
import java.text.NumberFormat

data class Money(val won: BigInteger) {
    init {
        require(won >= BigInteger.ZERO) { INVALID_MONEY_MESSAGE }
    }

    constructor(won: Int) : this(won.toBigInteger())

    operator fun plus(money: Money) = Money(won + money.won)

    operator fun times(count: Int) = Money(won * count.toBigInteger())

    operator fun div(count: Double) = won.toBigDecimal().div(count.toBigDecimal())

    operator fun div(count: Int) = won.div(count.toBigInteger())

    operator fun div(count: BigDecimal): BigDecimal = won.toBigDecimal().divide(count)

    fun div(money: Money, scaleValue: Int = SCALE_VALUE, roundingMode: RoundingMode = RoundingMode.HALF_EVEN): BigDecimal = won.toBigDecimal().divide(money.toBigDecimal(), scaleValue, roundingMode)

    fun toBigDecimal() = won.toBigDecimal()

    override fun toString(): String {
        return "${numberInstance.format(won)}원"
    }

    companion object {
        private val numberInstance = NumberFormat.getNumberInstance()
        private const val SCALE_VALUE = 2
        private const val INVALID_MONEY_MESSAGE = "음수는 Money로 사용될 수 없습니다."
    }
}
