package lotto.provider

import lotto.domain.LottoResult
import lotto.domain.LottoTickets
import lotto.domain.WinningNumber

object ResultProvider {
    fun provideLottoResult(
        lottoTickets: LottoTickets,
        winningNumber: WinningNumber,
        ticketPrice: Int,
        remainder: Int
    ): LottoResult {
        val result = mutableMapOf(
            (lotto.domain.Rank.ThreeHit to 0),
            (lotto.domain.Rank.FourHit to 0),
            (lotto.domain.Rank.FiveHit to 0),
            (lotto.domain.Rank.SixHit to 0),
        )

        lottoTickets.lottoTicketList.forEach { lottoTicket ->
            val hitCount = winningNumber.getHitCount(lottoTicket)
            if (lotto.domain.Rank.values().map { it.hitCount }.contains(hitCount)) {
                val rank = lotto.domain.Rank.values().find { it.hitCount == hitCount } ?: return@forEach
                result[rank]?.plus(1)
            }
        }

        var profit = 0

        lotto.domain.Rank.values().forEach { rank ->
            profit += rank.hitCount * rank.prize
        }

        val profitRate = String.format("%.2f", profit.toDouble() / ticketPrice.toDouble()).toDouble()

        return LottoResult(
            profit,
            ticketPrice,
            remainder,
            profitRate,
            result
        )
    }
}
