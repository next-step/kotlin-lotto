package lotto.domain

class LottoWinningNumber(private val lottoNumbers: LottoNumbers) {

    fun evaluateRank(lottoTicket: LottoTicket): LottoRank {
        val matchingCount = lottoTicket.getMatchCount(lottoNumbers)
        return LottoRank(matchingCount, lottoTicket.ticketAmount)
    }
}
