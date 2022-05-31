package lotto.domain

class LottoMachine {

    fun purchase(money: Money, manualTickets: LottoTickets, randomNumberFunc: () -> List<LottoNumber>): Purchase {
        val manualTicketPrice = manualTickets.lottoTickets.size * LOTTO_PRICE
        val autoTicketPrice = money.amount - manualTicketPrice

        val autoTickets = if (autoTicketPrice > 0) {
            val autoTicketCount = (money.amount - manualTicketPrice) / LOTTO_PRICE
            (1..autoTicketCount).toList().map {
                LottoTicket(randomNumberFunc())
            }
        } else emptyList()

        return Purchase(
            manualTickets = manualTickets,
            autoTickets = LottoTickets(autoTickets)
        )
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
