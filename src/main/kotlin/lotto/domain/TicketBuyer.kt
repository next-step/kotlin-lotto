package lotto.domain

class TicketBuyer {
    fun howMuchTickets(money: Int): Int {
        return money / TICKET_COST
    }

    companion object {
        const val TICKET_COST = 1000
    }
}
