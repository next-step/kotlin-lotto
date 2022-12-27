package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PaymentTest : StringSpec({
    "숫자 아닐때 에러 발생 테스트" {
        val exception = shouldThrowExactly<IllegalArgumentException> {
            Payment(-1)
        }
        exception.message shouldBe "지불액은 음수가 될 수 없습니다."
    }

    "지불금 차감 테스트" {
        // given
        val payment = Payment(1000)
        // when
        payment.charge(100)
        // then
        payment.payment shouldBe 900
    }

    "잔액 부족으로 지불금 차감 에러 테스트" {
        // given
        val payment = Payment(1000)
        // when
        val exception = shouldThrowExactly<IllegalArgumentException> {
            payment.charge(1100)
        }
        // then
        exception.message shouldBe "잔액 부족으로 금액을 차감할 수 없습니다."
    }
})
