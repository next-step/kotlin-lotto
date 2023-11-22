package lotto.domain

import java.math.BigDecimal

class WinningResult {
    private var result: MutableMap<Prize, Int> = mutableMapOf()

    fun recordPrize(prize: Prize) {
        if (prize == Prize.NONE) return
        result[prize] = result.getOrDefault(prize, 0) + 1
    }

    fun rateOfReturn(spentMoney: Money): BigDecimal {
        val totalEarning = result.map { it.key.award.amount * it.value }.sum()
        return BigDecimal(totalEarning).divide(BigDecimal(spentMoney.amount))
    }

    fun result() = result.toMap()
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as WinningResult

        if (result != other.result) return false

        return true
    }

    override fun hashCode(): Int {
        return result.hashCode()
    }
}
