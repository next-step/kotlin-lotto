package lotto.provider

import lotto.domain.LottoResult
import lotto.domain.LottoTickets
import lotto.domain.Rank
import lotto.domain.WinningNumber

object ResultProvider {
    fun provideLottoResult(
        lottoTickets: LottoTickets,
        winningNumber: WinningNumber,
        ticketPrice: Int,
        remainder: Int
    ): LottoResult {
        val result = mutableMapOf(
            (Rank.ThreeHit to 0),
            (Rank.FourHit to 0),
            (Rank.FiveHit to 0),
            (Rank.SixHit to 0),
        )

        lottoTickets.lottoTicketList.forEach { lottoTicket ->
            val hitCount = winningNumber.getHitCount(lottoTicket)
            if (Rank.values().map { it.hitCount }.contains(hitCount)) {
                val rank = Rank.values().find { it.hitCount == hitCount } ?: return@forEach
                result[rank] = (result[rank] ?: 0) + 1
            }
        }

        var profit: Long = 0

        Rank.values().forEach { rank ->
            profit += (result[rank] ?: 0) * rank.prize
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
