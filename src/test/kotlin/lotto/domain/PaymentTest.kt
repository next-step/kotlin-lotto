package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class PaymentTest : StringSpec({

    "구입 금액을 입력 받는다." {
        val inputPayment = 14000
        val payment = Payment(inputPayment)
        payment.money shouldBe inputPayment
    }

    "0 이하의 숫자가 들어올 경우 예외가 발생한다." {
        forAll(
            row(0),
            row(-1)
        ) { inputPayment ->
            shouldThrow<IllegalArgumentException> {
                Payment(inputPayment)
            }
        }
    }
})
