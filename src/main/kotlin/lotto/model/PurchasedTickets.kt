package lotto.model

const val TICKET_PRICE = 1000;

class PurchasedTickets(amount: Int) {
    val ticketCount = amount/TICKET_PRICE
}