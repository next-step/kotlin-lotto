package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

internal class PurchaseAmountTest : BehaviorSpec({
    given("구입 금액을 입력하고") {
        val purchaseAmounts = listOf(14000, 14300, 5500)
        purchaseAmounts.forAll {
            val purchaseAmount = PurchaseAmount(it)

            `when`("구입 금액을 로또 1장의 가격으로 나눈 값과 구입할 수 있는 로또의 갯수가 같다면") {
                val result = purchaseAmount.getNumberOfLotto()
                val expectedResult = purchaseAmount.getAmount() / 1000

                then("로또 1장의 가격은 1000원이다.") {
                    result shouldBe expectedResult
                }
            }
        }
    }
})
