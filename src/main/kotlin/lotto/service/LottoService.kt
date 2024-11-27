package lotto.service

import lotto.domain.BonusNumber
import lotto.domain.LottoPurchasingMachine
import lotto.domain.LottoRank
import lotto.domain.LottoTicket
import java.math.BigDecimal
import java.math.RoundingMode

class LottoService(
    private val lottoPurchasingMachine: LottoPurchasingMachine,
) {
    fun lottoIssuance(totalTicketCount: Int, manualTicketCount: Int): List<LottoTicket> {
        val autoTicketCount = maxOf(0, totalTicketCount - manualTicketCount)
        return (1..autoTicketCount).map { LottoTicket() }
    }

    fun calculateStatistics(
        tickets: List<LottoTicket>,
        winningNumbers: List<Int>,
        bonusNumber: BonusNumber
    ): Map<LottoRank, Int> {
        return tickets.groupingBy { ticket ->
            val matchCount = ticket.matchCount(winningNumbers)
            val hasBonus = matchCount == 5 && ticket.hasBonusNumber(bonusNumber)
            LottoRank.from(matchCount, hasBonus)
        }.eachCount()
    }

    fun calculateTotalPrize(statistics: Map<LottoRank, Int>): Int {
        return statistics.entries.sumOf { (rank, count) -> rank.prize * count }
    }

    fun calculateProfitRate(totalPrize: Int): BigDecimal {
        return totalPrize.toBigDecimal()
            .divide(lottoPurchasingMachine.money.toBigDecimal(), 2, RoundingMode.DOWN)
    }

    fun generateAutoTickets(buyCount: Int, manualQuantity: Int): List<LottoTicket> {
        val autoTicketCount = buyCount - manualQuantity
        return (1..autoTicketCount).map { LottoTicket() }
    }
}
