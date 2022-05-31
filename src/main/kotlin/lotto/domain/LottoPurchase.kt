package lotto.domain

class LottoPurchase {
    fun getLottoCount(price: LottoPrice): Int = price / LOTTO_PRICE

    fun getLottoTickets(count: Int): List<LottoTicket> {
        val lottoTickets = mutableListOf<LottoTicket>()
        repeat(count) {
            lottoTickets.add(LottoTicket.new())
        }
        return lottoTickets.toList()
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
