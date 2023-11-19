package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.string.shouldInclude

class LottoPolicyTest : StringSpec({

    "로또 구매 금액이 1000원 미만이면 예외가 발생한다" {
        forAll(
            row(900),
            row(990),
            row(999),
            row(500)
        ) { purchaseAmount ->
            shouldThrow<IllegalArgumentException> {
                LottoPolicy.validatePurchaseAmount(purchaseAmount)
            }.message shouldInclude "구매금액은 1000원 이상이어야 합니다."
        }
    }
})
