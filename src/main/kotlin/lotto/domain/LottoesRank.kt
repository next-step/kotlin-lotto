package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

class LottoesRank(
    private val value: Map<Rank, Int>
) {
    fun getRanks(): Map<Rank, Int> {
        return value
    }

    fun getWinningMoney(): Long {
        return value.map { rank ->
            rank.key.prizeMoney.toLong() * rank.value
        }.sum()
    }

    fun calcualteRateOfReutrn(spentMoney: Long): String {
        return BigDecimal(getWinningMoney())
            .divide(spentMoney.toBigDecimal(), 2, RoundingMode.FLOOR)
            .toString()
    }
}
