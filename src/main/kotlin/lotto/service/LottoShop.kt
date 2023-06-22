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
                    purchase()
                },
            )
        }

        private fun purchaseCount(purchaseMoney: Int): Int {
            return purchaseMoney / LOTTO_PRICE
        }

        private fun purchase(): Lotto {
            return Lotto(listOf(1, 2, 3, 4, 5, 6))
        }
    }
}
