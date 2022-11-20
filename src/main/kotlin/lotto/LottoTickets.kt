package lotto

class LottoTickets(ticketCount: Int) {
    val tickets: List<LottoTicket> = List(ticketCount) {
        AutoLottoTicket()
    }
}
