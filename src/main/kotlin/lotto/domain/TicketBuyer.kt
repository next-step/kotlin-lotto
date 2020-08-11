package lotto.domain

class TicketBuyer {
    companion object {
        fun howMuchTickets(money: Int): Int {
            return money / TICKET_COST
        }

        const val TICKET_COST = 1000
    }
}
