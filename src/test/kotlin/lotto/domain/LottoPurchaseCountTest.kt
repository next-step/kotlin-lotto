package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class LottoPurchaseCountTest : StringSpec({
    "로또 구매 금액은 1000 미만 이면 예외를 발생한다" {
        shouldThrow<IllegalArgumentException> { LottoPurchaseCount(999) }
    }
})
