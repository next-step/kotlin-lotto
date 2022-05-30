package lotto

class LottoMachine {

    fun purchase(purchaseMoney: PurchaseMoney, randomNumberFunc: () -> List<LottoNumber>): LottoTickets {
        val lottoTicketCount = purchaseMoney.money / LOTTO_PRICE

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
