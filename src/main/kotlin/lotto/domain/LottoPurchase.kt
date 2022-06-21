package lotto.domain

class LottoPurchase {
    fun getLottoCount(price: LottoPrice): PositiveNumber = PositiveNumber(price / LOTTO_PRICE)

    fun getLottoTickets(count: PositiveNumber): LottoTickets {
        val lottoTickets = mutableListOf<LottoTicket>()
        repeat(count.toInt()) {
            lottoTickets.add(LottoTicket.new())
        }
        return LottoTickets(lottoTickets.toList())
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
