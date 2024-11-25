package lottery.domain

object TicketMachine {
    private const val LOTTERY_TICKET_PRICE = 1_000

    fun exchange(money: Money): List<Ticket> {
        require(money.amount >= LOTTERY_TICKET_PRICE) { "금액은 $LOTTERY_TICKET_PRICE 원 이상이어야 합니다" }
        require(money.amount % LOTTERY_TICKET_PRICE == 0) { "금액은 $LOTTERY_TICKET_PRICE 단위여야 합니다" }

        val ticketCount = money.amount / LOTTERY_TICKET_PRICE
        return List(ticketCount) { Ticket() }
    }
}
