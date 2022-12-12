package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.common.IntegerNumber

class PaymentTest : StringSpec({
    "숫자 아닐때 에러 발생 테스트" {
        val exception = shouldThrowExactly<IllegalArgumentException> {
            Payment(IntegerNumber(-1))
        }
        exception.message shouldBe "지불액은 음수가 될 수 없습니다."
    }
})
