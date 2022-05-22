package lotto.seller

import lotto.LottoTicket

class LottoSeller {

    fun calculateLottoPurchaseAmount(money: Int): Int {
        return money / LOTTO_PURCHASE_PRICE_PER_PIECE
    }

    fun sell(amount: Int, selectedLottoNumber: List<Int>): List<LottoTicket> {
        val purchaseLottoTickets = mutableListOf<LottoTicket>()
        repeat(amount) {
            purchaseLottoTickets.add(LottoTicket(selectedLottoNumber))
        }

        return purchaseLottoTickets
    }

    fun takeLottoNumbers(): List<Int> {
        val grabs = mutableSetOf<Int>()
        while (grabs.size < 6) {
            grabs.add(LOTTO_NUMBER_RANGE.random())
        }

        return grabs.toList()
    }

    companion object {
        const val LOTTO_PURCHASE_PRICE_PER_PIECE = 1_000
        val LOTTO_NUMBER_RANGE = IntRange(1, 45)

    }
}
