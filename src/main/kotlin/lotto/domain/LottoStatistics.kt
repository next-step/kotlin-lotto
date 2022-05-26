package lotto.domain

import java.math.BigDecimal
import java.math.MathContext

class LottoStatistics(
    private val lottoTickets: LottoTickets,
    private val lastLottoTicket: LottoTicket,
    private val lastLottoBonusNumber: Int
) {

    init {
        require(lastLottoBonusNumber in LottoTicket.RANGE_OF_LOTTO_NUMBER)
        require(lastLottoTicket.numbers.contains(lastLottoBonusNumber).not())
    }

    fun getMatchCount(match: LottoMatch): Int =
        lottoTickets.getMatchCount(match, lastLottoTicket, lastLottoBonusNumber)

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
