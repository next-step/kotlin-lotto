package lotto

object LottoStore {
    const val PRICE_OF_ONE_LOTTO_TICKET = 1000
    const val MAXIMUM_SIZE_OF_TICKET = 100

    fun buy(money: Int): List<LottoTicket> {
        require(money >= PRICE_OF_ONE_LOTTO_TICKET)
        require(money <= PRICE_OF_ONE_LOTTO_TICKET * MAXIMUM_SIZE_OF_TICKET)
        val numberOfTicket = money / PRICE_OF_ONE_LOTTO_TICKET
        return LottoTicketMachine.generate(numberOfTicket)
    }
}
