package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
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

            `when`("수동으로 구매할 로또의 개수가 살 수 있는 로또의 개수보다 클 때") {
                val numberOfLottoByManual = 15
                val result = purchaseAmount.canBuyNumberOfLotto(numberOfLottoByManual)

                then("로또를 구매할 수 없다.") {
                    result shouldBe false
                }
            }
        }
    }
})
