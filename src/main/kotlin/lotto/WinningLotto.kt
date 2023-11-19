package lotto

class WinningLotto(private val winningNumbers: List<Int>, private val bonusNumber: Int) {

    fun checkRanking(lottoTicket: LottoTicket): LottoRanking {
        val matchedNumberSize = winningNumbers.intersect(
            lottoTicket.numbers.toSet()
        ).size
        val isBonusMatched = lottoTicket.isNumberMatched(bonusNumber)

        return LottoRanking.valueOf(matchedNumberSize, isBonusMatched)
    }

    fun createResultAnalytics(lottoTickets: LottoTickets): LottoResultAnalytics {
        val rankingsCount = lottoTickets.values
            .map { this.checkRanking(it) }
            .groupingBy { it }
            .eachCount()

        return LottoResultAnalytics(rankingsCount)
    }
}
