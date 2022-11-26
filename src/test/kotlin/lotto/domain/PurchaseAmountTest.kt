package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import kotlin.IllegalArgumentException

internal class PurchaseAmountTest : BehaviorSpec({
    given("구입 금액을 입력할 때") {
        `when`("최소 구입 금액인 1000원 아래로 입력하면") {
            val purchaseAmount = 300

            then("IllegalArgumentException 이 발생한다.") {
                shouldThrow<IllegalArgumentException> {
                    PurchaseAmount(purchaseAmount)
                }
            }
        }
    }
})
