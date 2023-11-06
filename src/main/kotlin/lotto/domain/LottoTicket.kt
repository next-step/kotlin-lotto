package lotto.domain

class LottoTicket(
    private val ticketAmount: Amount,
    val lottos: List<LottoNumbers>
) {

    fun evaluateRank(winningNumber: LottoWinningNumber): LottoRank {
        val matchResults = lottos.map { winningNumber.evaluateMatchResult(it) }
        return LottoRank(matchResults, ticketAmount)
    }
}
