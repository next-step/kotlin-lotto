package lotto.service

import lotto.domain.Lotto
import lotto.domain.Lottos

class LottoShop {

    companion object {
        private const val LOTTO_PRICE = 1000

        fun purchase(purchaseMoney: Long): Lottos {
            val purchaseCount = purchaseCount(purchaseMoney)

            return Lottos(
                (1..purchaseCount).map {
                    LottoGenerator.generate()
                },
            )
        }

        private fun purchaseCount(purchaseMoney: Long): Long {
            return purchaseMoney / LOTTO_PRICE
        }
    }
}

class LottoGenerator {

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        private const val LOTTO_NUMBER_MIN = 1
        private const val LOTTO_NUMBER_MAX = 45

        fun generate(): Lotto {
            return Lotto(
                (LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX)
                    .shuffled()
                    .take(LOTTO_NUMBER_COUNT)
                    .sorted(),
            )
        }
    }
}
