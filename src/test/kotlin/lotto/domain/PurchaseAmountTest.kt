package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PurchaseAmountTest : StringSpec({
    "should create PurchaseAmount with valid amount" {
        val purchaseAmount = PurchaseAmount(1000)
        purchaseAmount.getValue() shouldBe 1000
    }

    "should throw exception if amount is less than Lotto price" {
        val exception =
            shouldThrow<IllegalArgumentException> {
                PurchaseAmount(500)
            }
        exception.message shouldBe "구입 금액은 ${LottoStore.LOTTO_PRICE}원 이상이어야 합니다."
    }

    "should throw exception if amount is negative" {
        val exception =
            shouldThrow<IllegalArgumentException> {
                PurchaseAmount(-1000)
            }
        exception.message shouldBe "구입 금액은 ${LottoStore.LOTTO_PRICE}원 이상이어야 합니다."
    }
})
