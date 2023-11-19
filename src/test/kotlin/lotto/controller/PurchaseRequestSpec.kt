package lotto.controller

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith
import lotto.domain.LottoStore.Companion.LOTTO_PRICE
import lotto.presentation.controller.PurchaseRequest

class PurchaseRequestSpec : BehaviorSpec({
    given("구입 금액이 주어졌을 때") {
        val inputAmount = "1000"

        `when`("구입 요청을 생성한다") {
            val result = PurchaseRequest.from(inputAmount)

            then("구입 요청이 생성된다") {
                result.amount shouldBe LOTTO_PRICE
            }
        }
    }

    given("구입 금액이 로또 가격의 배수가 아닌 입력값이 주어졌을 때") {
        val inputAmount = "1500"

        `when`("구입 요청을 거절한다.") {
            val exception = shouldThrow<IllegalArgumentException> {
                PurchaseRequest.from(inputAmount)
            }

            exception.message shouldBe "구입 금액은 로또 가격의 배수여야 합니다."
        }
    }

    given("구입 금액이 숫자가 아닌 입력값이 주어졌을 때") {
        val inputAmount = "천"

        `when`("구입 요청을 거절한다.") {
            val exception = shouldThrow<IllegalArgumentException> {
                PurchaseRequest.from(inputAmount)
            }

            exception.message should startWith("구입 금액은 정수여야 합니다")
        }
    }
})
