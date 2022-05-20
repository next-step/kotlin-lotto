package lotto.domain

class LottoTickets(val lottoTickets: List<LottoTicket>) {

    fun matching(winningLotto: LottoTicket): LottoRanks {
        val lottoRanks = lottoTickets.map {
            val matchCount = winningLotto.matching(it)
            LottoRank.of(matchCount)
        }
        return LottoRanks(lottoRanks)
    }
}
