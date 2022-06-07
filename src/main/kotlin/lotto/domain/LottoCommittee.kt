package lotto.domain

import lotto.domain.enum.Priority
import lotto.domain.`interface`.LottoFixedNumbers

object LottoCommittee {
    fun createWinningTicket(input: String, bonusBall: String): WinningTicket {
        val lottoTicket = LottoTicket(LottoFixedNumbers().createNumbers(input.split(",").map { it.toInt() }))
        return WinningTicket(lottoTicket, bonusBall.toInt())
    }

    fun calculateStatistics(
        lottos: Lottos,
        winningTicket: WinningTicket
    ): Map<Priority, Int> {
        return lottos.calculatePriorities(winningTicket)
    }

    fun calculateReturnRate(price: Int, statistics: Map<Priority, Int>): Double {
        return (calculateReturnPrice(statistics) / price.toDouble())
    }

    private fun calculateReturnPrice(statistics: Map<Priority, Int>): Long {
        var returnPrice: Long = 0

        for ((priority, matchCount) in statistics) {
            returnPrice += matchCount * Priority.getPrice(priority.matchCount)
        }

        return returnPrice
    }
}
