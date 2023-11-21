package specific.lotto.domain

class Player(val money: Money, ticketMachine: TicketMachine) {

    val tickets: Tickets = ticketMachine.sellTickets(money)

    fun receivePrize(winningResult: WinningResult) {
        money.make(winningResult.totalPrize)
    }
}
