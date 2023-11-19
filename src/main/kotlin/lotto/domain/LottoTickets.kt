package lotto.domain

import lotto.domain.vo.RankFrequency
import lotto.presentation.controller.LottoResult

class LottoTickets(val tickets: List<LottoNumber>) {
    fun aggregateByRank(winningNumber: LottoNumber, bonusNumber: Int): LottoResult =
        tickets
            .map { ticket ->
                // TODO : 리펙토링, map 이 너무 비대하다. 역할 분배 필요
                val countOfMatch = ticket countSameNumberWith winningNumber
                val isBonusNumberMatched = ticket contains bonusNumber
                Rank.valueOf(countOfMatch, isBonusNumberMatched)
            }
            .groupBy { it }
            .mapValues { RankFrequency.of(it.value.size) }
            .let(::LottoResult)

    fun size(): Int = tickets.size

    companion object {
        fun of(tickets: List<LottoNumber>): LottoTickets = LottoTickets(tickets)
    }
}
