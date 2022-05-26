package lotto.domain

import java.math.BigDecimal
import java.math.MathContext

class LottoStatistics(
    private val lottoTickets: LottoTickets,
    private val lottoLastNumbers: LottoLastNumbers
) {

    fun getMatchCount(match: LottoMatch): Int = lottoTickets.getMatchCount(match, lottoLastNumbers)

    fun getProfit(purchase: Int): BigDecimal {
        require(purchase > 0)
        return getRewards().divide(purchase.toBigDecimal(), MathContext.DECIMAL128)
    }

    private fun getRewards(): BigDecimal =
        LottoMatch
            .values()
            .sumOf { getMatchCount(it) * it.reward }
            .toBigDecimal()
}
