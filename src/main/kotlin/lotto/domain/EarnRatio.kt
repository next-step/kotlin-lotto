package lotto.domain

import java.math.BigDecimal

object EarnRatio {

    fun calculate(useMoney: Int, lottoResults: List<LottoResult>): BigDecimal {
        val totalMoney = BigDecimal(lottoResults.totalPrizeMoney())
        return totalMoney.divide(BigDecimal(useMoney))
    }

    private fun List<LottoResult>.totalPrizeMoney(): Long {
        return this.map { it.prize }.sum()
    }
}
