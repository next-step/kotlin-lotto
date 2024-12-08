package lotto.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class LottosTest : FreeSpec({
    "로또 구매 가격을 계산한다" {
        val userLottos =
            UserLottos(
                listOf(
                    Lotto(1, 2, 3, 4, 5, 6),
                    Lotto(1, 2, 3, 4, 5, 6),
                    Lotto(1, 2, 3, 4, 5, 6),
                    Lotto(1, 2, 3, 4, 5, 6),
                    Lotto(1, 2, 3, 4, 5, 6),
                ),
            )

        val purchaseAmount = userLottos.calculatePurchaseAmount()

        purchaseAmount shouldBe 5 * Lotto.MIN_AMOUNT_UNIT
    }
})
