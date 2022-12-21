package lotto.domain

import lotto.domain.vo.LottoNumber
import lotto.domain.vo.PurchaseAmount

object LottoMachine {
    private const val LOTTO_PRICE: Int = 1000

    private val LOTTO_NUMBERS = LottoNumber.MIN_VALUE..LottoNumber.MAX_VALUE

    fun createAutoLottoNumbers(purchaseAmount: PurchaseAmount, manualLottoCount: Int): List<LottoNumbers> {
        val purchaseAmountForAutoLotto = purchaseAmount - (manualLottoCount * LOTTO_PRICE)

        return List(purchaseAmountForAutoLotto.countTicket(LOTTO_PRICE)) { LottoNumbers(LOTTO_NUMBERS.shuffled().take(LottoNumbers.SIZE)) }
    }
}
