package lotto.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PurchaseAmountTest : StringSpec({

    "구매급액 객체를 생성하면 천원단위로 count 를 반환한다" {
        // when
        val purchaseAmount = PurchaseAmount(14000)
        // then
        purchaseAmount.count() shouldBe 14
    }
})
