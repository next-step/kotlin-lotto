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

    fun execute(): LottoSummary {
        val winnerLottoTicket = getWinnerTicket()
        val lottoInfos = lottoTickets.map { ticket ->
            val countMatchResult = winnerLottoTicket.countMatchNumber(ticket)
            LottoInfo.of(countMatchResult.count, countMatchResult.isBonusNumberMatched)
        }
        return LottoSummary(lottoInfos)
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
