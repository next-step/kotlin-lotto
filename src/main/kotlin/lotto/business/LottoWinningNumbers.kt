package lotto.business

data class LottoWinningNumbers(val lottoNumbers: List<LottoNumber>) {
    fun matchCount(lottoTicket: LottoTicket): Int {
        return lottoTicket.matchCount(lottoNumbers)
    }
}
