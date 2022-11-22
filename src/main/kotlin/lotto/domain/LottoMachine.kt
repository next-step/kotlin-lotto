package lotto.domain

class LottoMachine(
    money: Int
) {
    private val lottoTickets: LottoTickets
    private lateinit var lottoSummary: LottoSummary

    init {
        val ticketCount = money / TICKET_AMOUNT
        println("${ticketCount}개를 구매했습니다.")
        lottoTickets = LottoTickets(ticketCount)
    }

    fun getSummary(): LottoSummary {
        execute()
        return lottoSummary
    }

    private fun execute() {
        val winnerLottoTicket = WinnerLottoTicket(LottoManualGenerateStrategy())
        val lottoInfos = lottoTickets.tickets.map { ticket ->
            val matchNumber = winnerLottoTicket.countMatchNumber(ticket.lottoNumbers)
            LottoInfo.of(matchNumber)
        }
        lottoSummary = LottoSummary(lottoInfos)
    }

    companion object {
        private const val TICKET_AMOUNT = 1000
    }
}
