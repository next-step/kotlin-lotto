package lotto.controller

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class PurchaseRequestSpec : FunSpec({
    test("입력 금액으로 구매 요청이 생성된다") {
        val inputAmount = "1000"

        val result = PurchaseRequest.from(inputAmount)

        result.amount shouldBe 1000
    }

    test("정수 형식의 입력 금액 아닌 경우 구매 요청 생성이 실패한다") {
        val inputAmount = "100!"

        shouldThrow<IllegalArgumentException> {
            PurchaseRequest.from(inputAmount)
        }
    }
})
