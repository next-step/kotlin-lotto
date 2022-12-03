package lotto.domain

class LottoMachine(
    money: Int,
    lottoGenerateStrategy: LottoGenerateStrategy,
    private val winnerLottoGenerateStrategy: LottoGenerateStrategy,
    private val bonusGenerateStrategy: BonusGenerateStrategy,
) {
    val lottoTickets: LottoTickets = LottoTickets(
        List(money / TICKET_AMOUNT) { lottoGenerateStrategy.generate() }
    )

    fun execute(): LottoResultSummary {
        val winnerLottoTicket = getWinnerTicket()
        val matchResults = lottoTickets.map { ticket ->
            val countMatchResult = winnerLottoTicket.countMatchNumber(ticket)
            MatchResult.of(countMatchResult.count, countMatchResult.isBonusNumberMatched)
        }
        return LottoResultSummary(matchResults)
    }

    private fun getWinnerTicket(): WinnerLottoTicket {
        val winnerLottoNumbers = winnerLottoGenerateStrategy.generate()
        val bonusNumber = bonusGenerateStrategy.generate()
        return WinnerLottoTicket(winnerLottoNumbers, bonusNumber)
    }

    companion object {
        private const val TICKET_AMOUNT = 1000
    }
}
