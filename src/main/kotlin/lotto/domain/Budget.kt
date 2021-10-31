package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

@JvmInline
value class Budget private constructor(val value: Int) {
    init {
        require(value >= LOTTO_PRICE) { throw IllegalArgumentException(MINIMUM_VALUE_REQUIRED) }
    }

    fun getTotalLottoCount(): Int {
        return value / LOTTO_PRICE
    }

    fun getProfit(compareAmount: Int): BigDecimal {
        val convertedAmount = compareAmount.toBigDecimal()
        return convertedAmount.divide(value.toBigDecimal(), NUMBER_FORMAT, RoundingMode.DOWN)
    }

    fun validateManualCount(manualCount: Int): Boolean {
        return getTotalLottoCount() > manualCount
    }

    fun getRemainCount(count: Int): Int {
        return getTotalLottoCount() - count
    }

    companion object {
        private const val LOTTO_PRICE = 1000
        private const val MINIMUM_VALUE_REQUIRED = "최소 로또 금액이 되어야합니다."
        private const val NUMBER_FORMAT = 2

        fun valueOf(value: Int): Budget {
            return Budget(value)
        }
    }
}
