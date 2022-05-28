package lotto.domain

class LottoMachine {
    fun buy(money: Int): List<Lotto> {
        require(money >= 1000) { ERROR_NOT_ENOUGH_MONEY }

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

        private const val ERROR_NOT_ENOUGH_MONEY = "로또를 구입하기 위해서는 최소 1000원 이상 입력해야 한다."
    }
}
