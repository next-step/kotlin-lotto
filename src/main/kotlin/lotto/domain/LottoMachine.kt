package lotto.domain

import lotto.domain.vo.LottoNumber
import lotto.domain.vo.PurchaseAmount

object LottoMachine {
    private const val LOTTO_PRICE: Int = 1000

    private val LOTTO_NUMBERS = LottoNumber.MIN_VALUE..LottoNumber.MAX_VALUE

    fun createLottoNumbers(purchaseAmount: PurchaseAmount): List<LottoNumbers> {
        return List(purchaseAmount.div(LOTTO_PRICE)) { LottoNumbers(LOTTO_NUMBERS.shuffled().subList(0, LottoNumbers.SIZE)) }
    }
}
