package lotto.ui

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class PaymentInputTest : FunSpec({
    context("입력한 구입 금액 조회") {
        test("입력한 문자열 구입 금액을 숫자로 조회할 수 있다.") {
            val paymentInput = PaymentInput(value = "15000")
            val actual = paymentInput.getPayment()
            actual shouldBe 15000
        }
    }
})
