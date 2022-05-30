package lotto.domain

class LottoMachine {

    fun purchase(money: Money, randomNumberFunc: () -> List<LottoNumber>): LottoTickets {
        val lottoTicketCount = money.amount / LOTTO_PRICE

        return LottoTickets(
            (1..lottoTicketCount).toList().map {
                LottoTicket(randomNumberFunc())
            }
        )
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
