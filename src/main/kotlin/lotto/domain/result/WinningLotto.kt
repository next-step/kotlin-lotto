package lotto.domain.result

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets

class WinningLotto private constructor(val numbers: LottoTicket) {
    fun match(lottoTickets: LottoTickets): LottoResult {
        val matchCounts = lottoTickets.getMatchCounts(numbers)
        return LottoRank.rank(matchCounts)
    }

    companion object {
        fun of(input: String): WinningLotto {
            val lottoTicket = LottoTicket(input.split(", ").map { LottoNumber(it) }.toSet())
            return WinningLotto(lottoTicket)
        }
    }
}
