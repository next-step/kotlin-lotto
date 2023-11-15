package lotto

class LottoTickets {
    val values: List<LottoTicket>

    private constructor(ticketQuantity: Int) {
        this.values = List(ticketQuantity) { LottoTicket.generate() }
    }

    constructor(lottoTickets: List<LottoTicket>) {
        this.values = lottoTickets
    }

    fun getAllLottoNumbers(): List<List<Int>> {
        return values.map { it.numbers }
    }

    fun size(): Int {
        return values.size
    }

    companion object {
        fun buy(purchaseAmount: Int): LottoTickets {
            return LottoTickets(purchaseAmount / LottoPolicy.LOTTO_PRICE)
        }
    }
}
