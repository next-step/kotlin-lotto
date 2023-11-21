package specific.lotto.domain

class Player(val money: Money, ticketMachine: TicketMachine) {


    val tickets: Tickets = ticketMachine.sellTickets(money)

    fun receivePrize(winningResult: WinningResult) {
        check(winningResult != null) { "have to make 'winningResult' first" }
        money.make(winningResult.totalPrize)
    }

}
