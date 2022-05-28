package lotto.domain

import lotto.domain.model.Lotto
import lotto.domain.model.Lottos

object LottoBendingMachine {
    private const val LOTTO_PRICE = 1000

    fun purchase(purchaseAmount: Int): Lottos {
        val purchaseCount = getPurchaseCount(purchaseAmount)

        return makeLottos(purchaseCount)
    }

    private fun getPurchaseCount(purchaseAmount: Int): Int = purchaseAmount / LOTTO_PRICE

    private fun makeLottos(purchaseCount: Int): Lottos {
        val lottoList = List(purchaseCount) {
            Lotto.make()
        }

        return Lottos(lottoList)
    }
}
