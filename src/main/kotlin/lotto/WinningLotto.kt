package lotto

class WinningLotto(private val winningNumbers: List<Int>) {

    fun checkRanking(lottoTicket: LottoTicket): LottoRanking {
        val matchedNumberSize = winningNumbers.intersect(
            lottoTicket.numbers.toSet()
        ).size

        return LottoRanking.valueOf(matchedNumberSize)
    }
}
