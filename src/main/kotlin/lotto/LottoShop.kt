package lotto

class LottoShop(private val lottoMachine: LottoMachine = DefaultLottoMachine) {
    fun buying(amount: Long): LottoTickets {
        val ticketCount = (amount / LOTTO_TICKET_PRICE).toInt()
        return LottoTickets((1..ticketCount).map { lottoMachine.generate() })
    }

    companion object {
        private const val LOTTO_TICKET_PRICE = 1_000
    }
}
