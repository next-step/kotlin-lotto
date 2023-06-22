package lotto.service

import lotto.domain.Lotto
import lotto.domain.Lottos

class LottoShop {

    companion object {
        private const val LOTTO_PRICE = 1000

        fun purchase(purchaseMoney: Int): Lottos {
            val purchaseCount = purchaseCount(purchaseMoney)

            return Lottos(
                (1..purchaseCount).map {
                    LottoGenerator.generate()
                },
            )
        }

        private fun purchaseCount(purchaseMoney: Int): Int {
            return purchaseMoney / LOTTO_PRICE
        }
    }
}

class LottoGenerator {

    companion object {
        fun generate(): Lotto {
            return Lotto(
                1.rangeTo(45)
                    .toList()
                    .shuffled()
                    .take(6)
                    .sorted(),
            )
        }
    }
}
