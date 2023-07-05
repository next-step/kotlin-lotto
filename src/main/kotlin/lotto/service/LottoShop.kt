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
