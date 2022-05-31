package camp.nextstep.lotto.ticket

class LottoStore(private val lottoTicketPrice: Int, private val lottoTicketMachine: LottoTicketMachine) {

    fun exchangeAll(money: Int): LottoStoreReceipt {
        val ticketCount = money.div(lottoTicketPrice)
        val balance = money.rem(lottoTicketPrice)

        val tickets = mutableListOf<LottoTicket>()
        repeat(ticketCount) {
            tickets.add(issueTicket())
        }

        return LottoStoreReceipt(tickets, balance)
    }

    fun exchange(money: Int, numbers: List<List<Int>>): LottoStoreReceipt {
        require(money >= numbers.size * lottoTicketPrice) { "구입금액을 초과하였습니다. (구입금액=$money, 구입개수=${numbers.size})" }

        val tickets = numbers.map { lottoTicketMachine.issueTicket(it) }
        val balance = money - (tickets.size * lottoTicketPrice)

        return LottoStoreReceipt(tickets, balance)
    }

    private fun issueTicket(): LottoTicket {
        return lottoTicketMachine.issueTicket()
    }
}
