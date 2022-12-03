package lotto.domain

class LottoMachine(
    money: Int
) {
    val lottoTickets = LottoTickets(money / TICKET_AMOUNT)

    fun execute(): LottoSummary {
        val winnerLottoTicket = WinnerLottoTicket(LottoManualGenerateStrategy(), BonusManualGenerateStrategy())
        val lottoInfos = lottoTickets.tickets.map { ticket ->
            val countMatchResult = winnerLottoTicket.countMatchNumber(ticket)
            LottoInfo.of(countMatchResult.count, countMatchResult.isBonusNumberMatched)
        }
        return LottoSummary(lottoInfos)
    }

    companion object {
        private const val TICKET_AMOUNT = 1000
    }
}
