package lotto.service

import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import lotto.domain.Payment

class LottoPurchaseServiceTest : StringSpec({
    "5000원을 지불하면 로또 5장을 받는다" {
        LottoPurchaseService.purchase(Payment(5000), listOf(intArrayOf(1, 2, 3, 4, 5, 6))) shouldHaveSize 5
    }

    "수동 구매 개수는 지불금액을 초과할 수 없다" {
        shouldThrowAny {
            LottoPurchaseService.purchase(
                Payment(1000),
                listOf(intArrayOf(1, 2, 3, 4, 5, 6), intArrayOf(1, 2, 3, 4, 5, 6))
            )
        }
    }
})
