package lotto

class LottoMachine {

    var lottoTickets = LottoTickets()
        private set

    fun purchase(purchaseMoney: PurchaseMoney, randomNumberFunc: () -> List<LottoNumber>) {
        val lottoTicketCount = purchaseMoney.money / LOTTO_PRICE

        lottoTickets = LottoTickets(
            (1..lottoTicketCount).toList().map {
                LottoTicket(randomNumberFunc())
            }
        )
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
