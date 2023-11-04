package lotto.domain

class LottoTicket(val lottoNumbers: List<LottoNumbers>) {

    fun matchCount(winningNumber: LottoNumbers): List<Int> = lottoNumbers.map { winningNumber.getMatchCount(it) }
}
