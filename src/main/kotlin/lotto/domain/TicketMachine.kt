package lotto.domain

object TicketMachine {
    private const val LOTTO_TICKET_PRICE = 1_000

    fun exchange(
        purchaseAmount: Money,
        manualLottoNumbersList: List<LottoNumbers>,
    ): Tickets {
        require(purchaseAmount >= Money(LOTTO_TICKET_PRICE)) { "금액은 $LOTTO_TICKET_PRICE 원 이상이어야 합니다" }
        require(purchaseAmount.isDivisibleBy(LOTTO_TICKET_PRICE)) { "금액은 $LOTTO_TICKET_PRICE 단위여야 합니다" }

        val totalTicketCount = (purchaseAmount / Money(LOTTO_TICKET_PRICE)).toInt()
        val manualTickets = manualLottoNumbersList.map { ManualTicket(it) }
        val autoTickets = List(totalTicketCount - manualTickets.size) { AutoTicket }

        return Tickets(manualTickets, autoTickets)
    }
}
