package lotto.ticket

import lotto.result.PrizeRank

class LottoTicket(
    private val lottoNumbers: Set<LottoNumber>
) {

    fun match(winningTicket: WinningTicket): PrizeRank {
        val matchCount = lottoNumbers.filter { winningTicket.matchNumber(it) }.size
        return PrizeRank.ofMatchCount(matchCount)
    }
}