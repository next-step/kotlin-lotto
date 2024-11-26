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
    fun lottoIssuance(): List<LottoTicket> {
        return (1..lottoPurchasingMachine.buyCount()).map { LottoTicket() }
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
}
