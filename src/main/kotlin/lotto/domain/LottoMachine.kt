package lotto.domain

class LottoMachine {
    fun buy(money: Money, manualTickets: Tickets?): Tickets {
        val autoTicketCount = canBuyTicketCount(money) - (manualTickets?.count() ?: 0)
        val autoTickets = Tickets(List(autoTicketCount) { issueTicket() })
        return manualTickets?.merge(autoTickets) ?: autoTickets
    }

    private fun issueTicket(): Lotto {
        val numbers = (LottoNumber(LottoNumber.MIN_NUMBER)..LottoNumber(LottoNumber.MAX_NUMBER))
            .shuffled()
            .take(LOTTO_NUMBER_COUNT)
            .toSet()

        return Lotto.of(numbers)
    }

    fun canBuyTicketCount(money: Money) = money / TICKET_PRICE

    companion object {
        const val TICKET_PRICE = 1_000
        private const val LOTTO_NUMBER_COUNT = 6
    }
}
