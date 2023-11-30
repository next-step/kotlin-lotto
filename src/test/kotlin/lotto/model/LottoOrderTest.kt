package lotto.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.view.order.LottoOrder

class LottoOrderTest : StringSpec({

    "총 구매 수량보다 수동 구매 수량이 많게 입력되면 IllegalArgumentException throw" {
        shouldThrow<IllegalArgumentException> {
            LottoOrder(totalAmount = 14000, manualCount = 15).ticketing()
        }
    }

    "구매할 LottoGame 하나의 가격은 1000 이다" {
        LottoOrder(11, 2, 9).pricePerGame() shouldBe 1000
    }
})
