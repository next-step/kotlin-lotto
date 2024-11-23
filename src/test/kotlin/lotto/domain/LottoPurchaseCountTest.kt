package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoPurchaseCountTest : StringSpec({
    "또로 구매 개수가 1 이상이 아니면 예외 처리한다." {
        val exception = shouldThrowExactly<IllegalArgumentException> { LottoPurchaseCount(0) }
        exception.message shouldBe "로또 구매 개수는 1 이상이어야 합니다."
    }
})
