package lotto.service

import lotto.domain.Lotto
import lotto.domain.Lottos

object LottoShop {
    private const val LOTTO_PRICE = 1000

    fun purchase(purchaseMoney: Long, manualPurchaseLottos: Lottos? = null): Lottos {
        val manualPurchaseMoney = (manualPurchaseLottos?.size ?: 0) * LOTTO_PRICE

        val purchaseCount = purchaseCount(purchaseMoney - manualPurchaseMoney)

        return Lottos(
            (1..purchaseCount).map {
                LottoGenerator.generate()
            } + (manualPurchaseLottos?.lottos ?: emptyList()),
        )
    }

    private fun purchaseCount(purchaseMoney: Long): Long {
        return purchaseMoney / LOTTO_PRICE
    }
}

object LottoGenerator {
    fun generate(): Lotto {
        return Lotto(
            (Lotto.LOTTO_NUMBER_MIN..Lotto.LOTTO_NUMBER_MAX)
                .shuffled()
                .take(Lotto.LOTTO_NUMBER_SIZE)
                .sorted(),
        )
    }
}
