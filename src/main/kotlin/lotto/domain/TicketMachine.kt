package lotto.domain

object TicketMachine {
    private const val LOTTO_TICKET_PRICE = 1_000

    fun exchange(money: Money): List<AutoTicket> {
        require(money >= Money(LOTTO_TICKET_PRICE)) { "금액은 $LOTTO_TICKET_PRICE 원 이상이어야 합니다" }
        require(money.isDivisibleBy(LOTTO_TICKET_PRICE)) { "금액은 $LOTTO_TICKET_PRICE 단위여야 합니다" }

        val ticketCount = money / Money(LOTTO_TICKET_PRICE)
        return List(ticketCount.toInt()) { AutoTicket }
    }
}
