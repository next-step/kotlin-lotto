package lotto

class LottoMachine {
    fun buy(money: Int): List<Lotto> {
        val ticketCount: Int = money / TICKET_PRICE
        val tickets = mutableListOf<Lotto>()

        repeat(ticketCount) {
            tickets.add(issueTicket())
        }
        return tickets
    }

    private fun issueTicket(): Lotto {
        val numbers = (LottoNumber.MIN_NUMBER..LottoNumber.MAX_NUMBER)
            .shuffled()
            .take(LOTTO_NUMBER_COUNT)
            .toSet()

        return Lotto.of(numbers)
    }

    companion object {
        private const val TICKET_PRICE = 1_000
        private const val LOTTO_NUMBER_COUNT = 6
    }
}
