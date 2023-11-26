package specific.lotto.domain

class Player(val money: Money, manualTicketNumbers: List<List<Int>> = emptyList(), ticketMachine: TicketMachine) {

    val tickets: Tickets = ticketMachine.sellTickets(money, manualTicketNumbers)

    fun receivePrize(winningResult: WinningResult) {
        money.make(winningResult.totalPrize)
    }
}
