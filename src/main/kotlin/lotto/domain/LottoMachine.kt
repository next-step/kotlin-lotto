package lotto.domain

class LottoMachine {
    fun buy(money: Money): Tickets {
        val ticketCount: Int = money / TICKET_PRICE
        return Tickets(List(ticketCount) { issueTicket() })
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
