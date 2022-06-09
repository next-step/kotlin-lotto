package lotto.domain

import lotto.domain.model.LottoFactory
import lotto.domain.model.Lottos
import lotto.domain.model.Money

object LottoBendingMachine {
    private const val LOTTO_PRICE = 1000

    fun purchase(purchaseAmount: Money, lottoFactory: LottoFactory): Lottos {
        val purchaseCount = getPurchaseCount(purchaseAmount)

        return Lottos.of(purchaseCount, lottoFactory)
    }

    private fun getPurchaseCount(purchaseAmount: Money): Int = purchaseAmount.value / LOTTO_PRICE
}
