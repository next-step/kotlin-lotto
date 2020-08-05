package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

class Result(private val lottos: Lottos) {
    private val result: MutableMap<PrizeMoney, Int> = mutableMapOf(
        PrizeMoney.FOURTH to 0,
        PrizeMoney.THIRD to 0,
        PrizeMoney.SECOND to 0,
        PrizeMoney.FIRST to 0
    )
    private val prizeMoneys = getPrizeMoneys()

    fun getResult(): Map<PrizeMoney, Int> {
        PrizeMoney.values().filterNot { it == PrizeMoney.ELSE }
            .forEach { putWinningAmounts(it) }
        return result
    }

    private fun putWinningAmounts(PrizeMoney: PrizeMoney) {
        result[PrizeMoney] = prizeMoneys.filter { it == PrizeMoney }.size
    }

    private fun getPrizeMoneys(): List<PrizeMoney> {
        return lottos.matchCounts().map { PrizeMoney.getPrizeMoney(it) }
    }

    fun getProfitRatio(payment: Int): BigDecimal {
        val income = getResult().map { it.key.money * it.value }.sumBy { it }.toDouble()
        return BigDecimal(income / payment).setScale(2, RoundingMode.DOWN)
    }
}

enum class PrizeMoney(val condition: Int, val money: Int) {
    FOURTH(3, 5000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000),
    ELSE(0, 0);

    companion object {
        fun getPrizeMoney(matchCount: Int): PrizeMoney {
            return values().firstOrNull { it.condition == matchCount }
                ?: ELSE
        }
    }
}
