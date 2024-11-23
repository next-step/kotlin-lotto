package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoPurchaseAmountTest : StringSpec({
    "로또 구매 금액이 자연수가 아니면 예외 처리한다." {
        forAll(
            row(-1),
            row(0),
            row(-1000),
            row(-200),
            row(-99999),
        ) { amount ->
            val exception =
                shouldThrowExactly<IllegalArgumentException> {
                    LottoPurchaseAmount(amount)
                }

            exception.message shouldBe "로또 구매 금액은 자연수 여야 합니다."
        }
    }

    "로또 구매 금액이 1000원 단위가 아니면 예외 처리한다." {
        forAll(
            row(10),
            row(100),
            row(1001),
            row(2100),
            row(30030),
        ) { amount ->
            val exception =
                shouldThrowExactly<IllegalArgumentException> {
                    LottoPurchaseAmount(amount)
                }

            exception.message shouldBe "로또 구매 금액은 1000원 단위여야 합니다."
        }
    }

    "구입 금액에 해당하는 로또 개수를 반환할 수 있다." {
        forAll(
            row(1000, 1),
            row(2000, 2),
            row(12000, 12),
            row(40000, 40),
            row(5000, 5),
        ) { amount, expectedCount ->
            val lottoPurchaseAmount = LottoPurchaseAmount(amount)
            val lottoPurchaseCount = lottoPurchaseAmount.toLottoPurchaseCount()

            lottoPurchaseCount shouldBe LottoPurchaseCount(expectedCount)
        }
    }
})
