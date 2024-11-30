package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*

class LottosTest : FreeSpec({
    "로또 구매 가격을 계산한다" {
        val lottos = Lottos(
            listOf(
                Lotto(setOf(1, 2, 3, 4, 5, 6)),
                Lotto(setOf(1, 2, 3, 4, 5, 6)),
                Lotto(setOf(1, 2, 3, 4, 5, 6)),
                Lotto(setOf(1, 2, 3, 4, 5, 6)),
                Lotto(setOf(1, 2, 3, 4, 5, 6)),
            )
        )

        val purchaseAmount = lottos.calculatePurchaseAmount()

        purchaseAmount shouldBe 5 * Lotto.MIN_AMOUNT_UNIT
    }
})