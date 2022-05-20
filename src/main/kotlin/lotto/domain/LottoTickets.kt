package lotto.domain

class LottoTickets(val lottoTickets: List<LottoTicket>) {

    fun matching(winningLotto: LottoTicket): List<LottoRanking> {
        return lottoTickets.map {
            val matchCount = winningLotto.matching(it)
            LottoRanking.of(matchCount)
        }
    }
}
