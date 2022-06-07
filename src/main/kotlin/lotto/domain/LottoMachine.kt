package lotto.domain

class LottoMachine {
    fun buy(money: Money): List<Lotto> {

        val ticketCount: Int = money / TICKET_PRICE

        return List(ticketCount) { issueTicket() }
    }

    private fun issueTicket(): Lotto {
        val numbers = (LottoNumber(LottoNumber.MIN_NUMBER)..LottoNumber(LottoNumber.MAX_NUMBER))
            .shuffled()
            .take(LOTTO_NUMBER_COUNT)
            .toSet()

        return Lotto.of(numbers)
    }

    companion object {
        const val TICKET_PRICE = 1_000
        private const val LOTTO_NUMBER_COUNT = 6
    }
}
