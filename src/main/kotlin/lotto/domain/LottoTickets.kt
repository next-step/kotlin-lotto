package lotto.domain

import lotto.domain.result.MatchInfo
import lotto.domain.strategy.NumberGenerateStrategy

class LottoTickets(val tickets: List<LottoTicket>) {
    fun getMatchInfos(numbers: LottoTicket, bonusNumber: LottoNumber): List<MatchInfo> {
        return tickets.map { it.getMatchInfo(numbers, bonusNumber) }
    }

    companion object {
        fun create(count: Int, numberStrategy: NumberGenerateStrategy): LottoTickets {
            return LottoTickets((1..count).map { LottoTicket.create(numberStrategy) }.toList())
        }
    }
}
