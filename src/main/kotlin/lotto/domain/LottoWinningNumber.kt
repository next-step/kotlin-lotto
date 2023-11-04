package lotto.domain

class LottoWinningNumber(private val lottoNumbers: LottoNumbers) {

    fun match(lottoTicket: LottoTicket): LottoRank {
        val matchingCount = lottoTicket.matchCount(lottoNumbers)
        return LottoRank(matchingCount)
    }
}
