package lotto.domain

import java.math.BigDecimal
import java.math.MathContext

class LottoStatistics(
    private val lottoTickets: List<LottoTicket>,
    private val lastLottoNumbers: Set<Int>
) {

    init {
        require(lottoTickets.isNotEmpty())
    }

    fun getMatchCount(match: LottoMatch): Int = getMatchCount(match.count)

    private fun getMatchCount(matchCount: Int): Int =
        lottoTickets
            .filter { it.numbers.intersect(lastLottoNumbers).size == matchCount }
            .size

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
