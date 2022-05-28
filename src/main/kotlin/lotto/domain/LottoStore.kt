package lotto.domain

object LottoStore {
    const val PRICE_OF_ONE_LOTTO_TICKET = 1000
    private const val MAXIMUM_SIZE_OF_TICKET = 100

    /**
     * 로도 티켓 구매하기
     *
     * @return 구매한 로또 티켓 목록
     */
    fun buy(money: Int): LottoTickets {
        require(money >= PRICE_OF_ONE_LOTTO_TICKET)
        require(money <= PRICE_OF_ONE_LOTTO_TICKET * MAXIMUM_SIZE_OF_TICKET)

        return LottoTicketMachine.generate(getTicketCountByMoney(money))
    }

    private fun getTicketCountByMoney(money: Int): Int = money / PRICE_OF_ONE_LOTTO_TICKET
}
