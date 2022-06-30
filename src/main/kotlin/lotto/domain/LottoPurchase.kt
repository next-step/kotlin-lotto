package lotto.domain

class LottoPurchase {
    fun getLottoCount(price: LottoPrice): PositiveNumber = PositiveNumber(price / LOTTO_PRICE)

    fun getLottoTickets(count: PositiveNumber): LottoTickets {
        val lottoTickets = count.times {
            LottoTicket.new()
        }
        return LottoTickets(lottoTickets)
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
