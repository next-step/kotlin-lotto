package lotto.domain

object LottoMachine {
    const val LOTTO_TICKET_PRICE: Int = 1000

    fun buy(price: Int): List<LottoTicket> {
        require(price >= LOTTO_TICKET_PRICE) {
            "최소 ${LOTTO_TICKET_PRICE}원 이상 구매해야 합니다."
        }
        val ticketCount = price / LOTTO_TICKET_PRICE
        return dispense(ticketCount)
    }

    private fun dispense(ticketCount: Int): List<LottoTicket> {
        return (0 until ticketCount).map { LottoTicket.create() }
    }
}