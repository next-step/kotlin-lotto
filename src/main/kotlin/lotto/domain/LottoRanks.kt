package lotto.domain

import lotto.vo.Money
import java.math.BigDecimal
import java.math.RoundingMode

data class LottoRanks(val lottoRanks: List<LottoRank>) {

    fun count(): Map<LottoRank, Int> {
        return LottoRank.values()
            .associateWith { lottoRank -> lottoRanks.count { it == lottoRank } }
    }

    fun profitRate(base: Money, scale: Int = 2, roundingMode: RoundingMode = RoundingMode.HALF_UP): BigDecimal {
        return lottoRanks.asSequence()
            .map { it.winningAmount }
            .reduce { acc, money -> acc + money }
            .divide(base, scale, roundingMode)
    }
}
