package lotto.domain

class LottoMachine {

    fun purchase(money: Money, manualTickets: LottoTickets, randomNumberFunc: () -> List<LottoNumber> = DEFAULT_RANDOM_FUNC): Purchase {
        val autoTicketCount = (money - manualTickets.money).lottoCount
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
        private val DEFAULT_RANDOM_FUNC = Extractor.randomNumberFunc
    }
}
