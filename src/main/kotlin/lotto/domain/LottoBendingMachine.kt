package lotto.domain

import lotto.domain.model.LottoFactory
import lotto.domain.model.Lottos
import lotto.domain.model.Money
import lotto.domain.model.PurchaseCount

object LottoBendingMachine {
    val LOTTO_PRICE = Money.from(1_000)

    fun purchase(purchaseAmount: Money, lottoFactory: LottoFactory): Lottos {
        return Lottos.of(
            PurchaseCount.of(
                purchaseAmount = purchaseAmount,
                price = LOTTO_PRICE
            ),
            lottoFactory
        )
    }
}
