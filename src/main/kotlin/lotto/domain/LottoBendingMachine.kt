package lotto.domain

import lotto.domain.model.Lotto

object LottoBendingMachine {
    private const val LOTTO_PRICE = 1000

    fun purchase(purchaseAmount: Int): List<Lotto> {
        val purchaseCount = getPurchaseCount(purchaseAmount)

        return makeLottos(purchaseCount)
    }

    private fun getPurchaseCount(purchaseAmount: Int): Int = purchaseAmount / LOTTO_PRICE

    private fun makeLottos(purchaseCount: Int): List<Lotto> = List(purchaseCount) {
        LottoMaker.make()
    }
}
