package lotto.domain

import lotto.domain.model.LottoFactory
import lotto.domain.model.Lottos

object LottoBendingMachine {
    private const val LOTTO_PRICE = 1000

    fun purchase(purchaseAmount: Int, lottoFactory: LottoFactory): Lottos {
        val purchaseCount = getPurchaseCount(purchaseAmount)

        return makeLottos(purchaseCount, lottoFactory)
    }

    private fun getPurchaseCount(purchaseAmount: Int): Int = purchaseAmount / LOTTO_PRICE

    private fun makeLottos(purchaseCount: Int, lottoFactory: LottoFactory): Lottos {
        val lottoList = List(purchaseCount) {
            lottoFactory.create()
        }

        return Lottos(lottoList)
    }
}
