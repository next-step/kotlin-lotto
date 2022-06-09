package lotto.domain

data class LottoTickets(
    val lottoTickets: List<LottoTicket>
) : List<LottoTicket> by lottoTickets {

    fun getMatchCount(lottoRank: LottoRank, winningNumbers: LottoWinningNumber): Int {
        return lottoTickets.count() { lottoTicket -> lottoTicket.isMatch(lottoRank, winningNumbers) }
    }
}
