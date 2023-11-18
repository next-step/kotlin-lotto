package lotto.controller

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith

class PurchaseRequestSpec: BehaviorSpec({
    given("구입 금액이 주어졌을 때") {
        val inputAmount = "1000"

        `when`("구입 요청을 생성한다") {
            val result = PurchaseRequest.from(inputAmount)

            then("구입 요청이 생성된다") {
                result.amount shouldBe 1000
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

class PurchaseRequest(
    val amount: Int,
) {
    companion object {
        const val LOTTO_PRICE = 1_000
        fun from(inputAmount: String): PurchaseRequest {
            val amount = inputAmount.toIntOrNull() ?: throw IllegalArgumentException("구입 금액은 정수여야 합니다")
            require(amount % LOTTO_PRICE == 0) { "구입 금액은 로또 가격의 배수여야 합니다." }
            return PurchaseRequest(amount)
        }
    }
}