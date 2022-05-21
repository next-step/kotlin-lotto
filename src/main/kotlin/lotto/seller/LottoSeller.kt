package lotto.seller

import lotto.LottoTicket

class LottoSeller {

    fun calculateLottoPurchaseAmount(money: Int): Int {
        return money / LOTTO_PURCHASE_PRICE_PER_PIECE
    }

    fun sell(amount: Int): List<LottoTicket> {
        val purchaseLottoTickets = mutableListOf<LottoTicket>()
        repeat(amount) {
            purchaseLottoTickets.add(LottoTicket(listOf(1, 2, 3, 4, 5, 6)))
        }

        return purchaseLottoTickets
    }

    companion object {
        const val LOTTO_PURCHASE_PRICE_PER_PIECE = 1_000
    }
}
