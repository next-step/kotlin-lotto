package lotto.domain

object LottoStore {
    private const val PRICE_OF_ONE_LOTTO_TICKET = 1000
    private const val MAXIMUM_SIZE_OF_TICKET = 100

    /**
     * 로도 티켓 구매하기
     *
     * @return 로또 티켓 목록, 잔돈
     */
    fun buy(money: Int): Pair<List<LottoTicket>, Int> {
        require(money >= PRICE_OF_ONE_LOTTO_TICKET)
        require(money <= PRICE_OF_ONE_LOTTO_TICKET * MAXIMUM_SIZE_OF_TICKET)
        val numberOfTicket = money / PRICE_OF_ONE_LOTTO_TICKET
        val changes = money % PRICE_OF_ONE_LOTTO_TICKET
        return LottoTicketMachine.generate(numberOfTicket) to changes
    }
}
