package lotto.domain

object LottoStore {
    const val PRICE_OF_ONE_LOTTO_TICKET = 1000
    private const val MAXIMUM_SIZE_OF_TICKET = 100

    /**
     * 로도 티켓 구매하기
     *
     * @param money 구매 금액
     * @param manualTickets 수동 구입 로또 티켓
     * @return [LottoTickets] 구매한 로또 티켓 목록
     */
    fun buy(money: PurchaseMoney, manualTickets: List<LottoTicket> = emptyList()): LottoTickets {
        require(money >= PRICE_OF_ONE_LOTTO_TICKET)
        require(money <= PRICE_OF_ONE_LOTTO_TICKET * MAXIMUM_SIZE_OF_TICKET)

        val countOfAutoLotto = getTicketCountByMoney(money.amount) - manualTickets.size
        val autoTickets = LottoTicketMachine.generate(countOfAutoLotto)

        return LottoTickets(manualTickets + autoTickets)
    }

    private fun getTicketCountByMoney(amount: Int): Int = amount / PRICE_OF_ONE_LOTTO_TICKET
}
