package lotto.domain

import lotto.vo.Money
import java.math.BigDecimal
import java.math.RoundingMode

data class LottoRanks(val lottoRanks: List<LottoRank>) {

    fun count(): Map<LottoRank, Int> {
        return LottoRank.values()
            .associateWith { lottoRank -> lottoRanks.count { it == lottoRank } }
    }

    fun profitRate(base: Money): BigDecimal {
        return lottoRanks.asSequence()
            .map { it.winningAmount }
            .reduce { acc, money -> acc + money }
            .divide(base, PROFIT_RATE_SCALE, RoundingMode.HALF_UP)
    }

    companion object {
        private const val PROFIT_RATE_SCALE = 2
    }
}
