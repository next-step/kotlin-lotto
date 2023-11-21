package lotto.domain

import lotto.domain.vo.RankFrequency
import lotto.presentation.controller.LottoResult

class WinningLottoInfo private constructor(
    private val winningTicket: LottoTicket,
    private val bonusNumber: Int
) {
    fun aggregateByRank(tickets: List<LottoTicket>): LottoResult =
        rankTickets(tickets).groupingBy { it }
            .eachCount()
            .mapValues { RankFrequency.of(it.value) }
            .let(::LottoResult)

    private fun rankTickets(tickets: List<LottoTicket>): List<Rank> =
        tickets.map { ticket ->
            val countOfMatch = ticket countSameNumberWith winningTicket
            val isBonusNumberMatched = ticket contains bonusNumber
            Rank.valueOf(countOfMatch, isBonusNumberMatched)
        }


    companion object {
        fun of(winningNumber: LottoTicket, bonusNumber: Int): WinningLottoInfo =
            WinningLottoInfo(winningNumber, bonusNumber)
    }
}
