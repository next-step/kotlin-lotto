package lotto.domain

import lotto.domain.result.MatchInfo

class LottoTickets(val tickets: List<LottoTicket>) {
    fun getMatchInfos(winningNumbers: LottoTicket, bonusNumber: LottoNumber): List<MatchInfo> {
        return tickets.map { it.getMatchInfo(winningNumbers, bonusNumber) }
    }

    companion object {
        fun create(count: LottoCount, shuffleStrategy: (List<LottoNumber>) -> List<LottoNumber>): LottoTickets {
            return LottoTickets(count.repeat { LottoTicket.create(shuffleStrategy) })
        }
    }
}
