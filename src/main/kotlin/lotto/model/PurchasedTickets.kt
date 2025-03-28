package lotto.model

const val TICKET_PRICE = 1000;

class PurchasedTickets(private val tickets: List<TicketModel>) {
    companion object {
        fun buyTickets(amount: Int): PurchasedTickets {
            val ticketCount = amount/TICKET_PRICE
            return PurchasedTickets( List(ticketCount) { TicketModel.generate()} )
        }
    }
}