package lotto.domain

class LottoMachine {

    fun purchase(money: Money, manualTickets: LottoTickets, randomNumberFunc: () -> List<LottoNumber>): Purchase {
        val manualTicketPrice = manualTickets.lottoTickets.size * LOTTO_PRICE
        val autoTicketCount = (money.amount - manualTicketPrice) / LOTTO_PRICE
        val autoTickets = makeAutoTickets(autoTicketCount, randomNumberFunc)

        return Purchase(
            manualTickets = manualTickets,
            autoTickets = autoTickets
        )
    }

    private fun makeAutoTickets(ticketCount: Int, randomNumberFunc: () -> List<LottoNumber>): LottoTickets {
        if (ticketCount <= 0) return LottoTickets()

        return LottoTickets(
            (1..ticketCount).toList().map {
                LottoTicket(randomNumberFunc())
            }
        )
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
