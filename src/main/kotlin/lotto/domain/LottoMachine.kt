package lotto.domain

import lotto.domain.vo.PurchaseAmount

object LottoMachine {
    private const val LOTTO_PRICE: Int = 1000

    private val LOTTO_NUMBERS = 1..45

    fun createLottoNumbers(purchaseAmount: PurchaseAmount): List<LottoNumbers> {
        LOTTO_NUMBERS.shuffled().let { shuffledNumbers ->
            return List(purchaseAmount.amount.div(LOTTO_PRICE)) { LottoNumbers(shuffledNumbers.subList(0, 6)) }
        }
    }
}
