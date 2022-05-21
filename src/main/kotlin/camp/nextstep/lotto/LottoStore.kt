package camp.nextstep.lotto

class LottoStore(private val lottoTicketPrice: Int) {

    fun exchange(money: Int): Pair<List<LottoTicket>, Int> {
        val ticketCount = money.div(lottoTicketPrice)
        val balance = money.rem(lottoTicketPrice)

        val tickets = mutableListOf<LottoTicket>()
        repeat(ticketCount) {
            tickets.add(issueTicket())
        }

        return tickets to balance
    }

    private fun issueTicket(): LottoTicket {
        return LottoTicket(listOf(1, 2, 3, 4, 5, 6))
    }
}
