package lotto.domain.purchase

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class LottoPurchaseCountTest : StringSpec({
    "로또 구매 금액은 1000 미만 이면 예외를 발생시킨다." {
        shouldThrow<IllegalArgumentException> { LottoPurchaseCount(999, Amount(10)) }
    }

    "수동 로또 구매 개수가 구매 금액 보다 크면 예외를 발생시킨다." {
        shouldThrow<IllegalArgumentException> { LottoPurchaseCount(1000, Amount(10)) }
    }
})
