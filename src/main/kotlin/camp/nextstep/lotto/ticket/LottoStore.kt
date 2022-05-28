package camp.nextstep.lotto.ticket

class LottoStore(private val lottoTicketPrice: Int, private val lottoTicketMachine: LottoTicketMachine) {

    fun exchange(money: Int): LottoStoreReceipt {
        val ticketCount = money.div(lottoTicketPrice)
        val balance = money.rem(lottoTicketPrice)

        val tickets = mutableListOf<LottoTicket>()
        repeat(ticketCount) {
            tickets.add(issueTicket())
        }

        return LottoStoreReceipt(tickets, balance)
    }

    private fun issueTicket(): LottoTicket {
        return lottoTicketMachine.issueTicket()
    }
}
