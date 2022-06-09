package lotto.domain

import lotto.domain.model.LottoFactory
import lotto.domain.model.LottoReceipt
import lotto.domain.model.Lottos
import lotto.domain.model.Money
import lotto.domain.model.PurchaseCount

object LottoBendingMachine {
    val LOTTO_PRICE = Money.from(1_000)

    fun purchaseAutomaticLottos(purchaseAmount: Money, lottoFactory: LottoFactory): LottoReceipt {
        val purchaseCount = PurchaseCount.of(
            purchaseAmount = purchaseAmount,
            price = LOTTO_PRICE
        )
        val lottos = Lottos.of(purchaseCount, lottoFactory)
        return LottoReceipt(purchaseCount, lottos)
    }
}
