package lotto

class WinningLotto(val winningNumbers: List<Int>) {
    
    fun checkRanking(lottoTicket: LottoTicket): LottoRanking {
        val matchedNumberSize = winningNumbers.intersect(lottoTicket.numbers).size

        return LottoRanking.valueOf(matchedNumberSize)
    }
}
