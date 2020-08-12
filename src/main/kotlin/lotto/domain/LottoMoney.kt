package lotto.domain

data class LottoMoney(
    val value: Long
) {
    val ticketCountCanBuy: Int = (this.value / LottoTicket.PRICE).toInt()

    fun spendTicketCountOf(count: Int): LottoMoney {
        return LottoMoney(this.value - LottoTicket.PRICE * count)
    }
}
