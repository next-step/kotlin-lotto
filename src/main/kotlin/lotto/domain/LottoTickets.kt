package lotto.domain

class LottoTickets(val lottoTickets: List<LottoTicket>) {

    fun matching(winningLotto: LottoTicket): List<LottoRank> {
        return lottoTickets.map {
            val matchCount = winningLotto.matching(it)
            LottoRank.of(matchCount)
        }
    }
}
