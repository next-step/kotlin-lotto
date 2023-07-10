package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class PurchaseMoneyTest : FunSpec({
    context("로또 구입 금액은 0원 이상이어야 한다.") {
        val exception = shouldThrow<IllegalArgumentException> {
            PurchaseMoney(-1)
        }
        exception.message shouldBe "로또 구입 금액은 최소 0원 이상이어야 합니다."
    }
})
