package lotto.domain

object LotteryTicketMachine {
    private const val LOTTERY_TICKET_PRICE = 1000

    fun ticketing(purchasePrice: Int): Int {
        return purchasePrice / LOTTERY_TICKET_PRICE
    }
}