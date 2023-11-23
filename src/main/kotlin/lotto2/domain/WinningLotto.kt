package lotto2.domain

class WinningLotto(private val winningNumbers: LottoNumbers, private val bonusNumber: LottoNumber) {
    init {
        require(bonusNumber !in winningNumbers) { "당첨 번호와 보너스 번호는 중복될 수 없습니다." }
    }

    fun getRankings(lottoTickets: List<LottoTicket>): LottoRankings {
        return LottoRankings(
            lottoTickets.map { checkRanking(it) }
                .groupingBy { it }
                .eachCount()
        )
    }

    private fun checkRanking(lottoTicket: LottoTicket): LottoRanking {
        val matchedNumberSize = winningNumbers.countMatchingNumbers(lottoTicket.numbers)
        val isBonusMatched = lottoTicket.isNumberMatched(bonusNumber)

        return LottoRanking.valueOf(matchedNumberSize, isBonusMatched)
    }
}
