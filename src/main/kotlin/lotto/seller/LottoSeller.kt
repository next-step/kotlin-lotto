package lotto.seller

import lotto.agency.LottoNumberGenerator
import lotto.agency.LottoTicket
import lotto.exception.MinimumPurchaseMoneyException

class LottoSeller {

    fun calculateLottoPurchaseAmount(money: Int): Int {
        validatePurchaseMoney(money)
        return money / LOTTO_PURCHASE_PRICE_PER_PIECE
    }

    fun buy(amount: Int): List<LottoTicket> {
        return List(amount) {
            LottoTicket(LottoNumberGenerator().getRandomLottoNumbers())
        }
    }

    private fun validatePurchaseMoney(money: Int) {
        if (money < LOTTO_PURCHASE_PRICE_PER_PIECE) {
            throw MinimumPurchaseMoneyException("최소 ${LOTTO_PURCHASE_PRICE_PER_PIECE}원 이상 지불하셔야 로또 구매가 가능합니다.")
        }
    }

    companion object {
        const val LOTTO_PURCHASE_PRICE_PER_PIECE = 1_000
    }
}
