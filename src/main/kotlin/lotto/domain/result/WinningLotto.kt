package lotto.domain.result

import lotto.domain.LottoNumber
import lotto.domain.LottoTickets

class WinningLotto private constructor(val numbers: List<LottoNumber>) {
    fun match(lottoTickets: LottoTickets): LottoResult {
        val matchCounts = lottoTickets.getMatchCounts(numbers)
        return LottoRank.rank(matchCounts)
    }

    companion object {
        fun of(input: String): WinningLotto {
            return WinningLotto(input.split(", ").map { LottoNumber(it) })
        }
    }
}
