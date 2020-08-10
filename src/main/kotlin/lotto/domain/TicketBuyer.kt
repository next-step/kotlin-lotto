package lotto.domain

class TicketBuyer {
    fun howMuchTickets(money: Int): Int {
        return money / TICKET_COST
    }

    companion object {
        private const val TICKET_COST = 1000
    }
}
