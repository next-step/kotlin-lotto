package lotto.domain

import java.math.BigDecimal
import java.math.MathContext

class LottoStatistics(
    private val lottoTickets: List<LottoTicket>,
    private val lastLottoTicket: LottoTicket,
    private val lastLottoBonusNumber: Int
) {

    init {
        require(lottoTickets.isNotEmpty())
        require(lastLottoBonusNumber in LottoTicket.RANGE_OF_LOTTO_NUMBER)
        require(lastLottoTicket.numbers.contains(lastLottoBonusNumber).not())
    }

    fun getMatchCount(match: LottoMatch): Int =
        if (match.withBonus) getMatchCountWithBonus(match) else getMatchCountWithoutBonus(match)

    private fun getMatchCountWithBonus(match: LottoMatch): Int =
        getMatchTicket(match)
            .filter {
                it.numbers.contains(lastLottoBonusNumber)
            }
            .size

    private fun getMatchCountWithoutBonus(match: LottoMatch): Int =
        getMatchTicket(match)
            .filterNot {
                it.numbers.contains(lastLottoBonusNumber)
            }
            .size

    private fun getMatchTicket(match: LottoMatch): List<LottoTicket> =
        lottoTickets.filter { it.numbers.intersect(lastLottoTicket.numbers).size == match.count }

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
