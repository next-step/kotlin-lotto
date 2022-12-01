package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row

class PaymentTest : StringSpec({
    "지불 단위는 1000원이다" {
        shouldNotThrowAny { Payment(1000) }
    }

    "범위를 벗어난 지불 금액을 생성할 시 예외를 던진다" {
        forAll(
            row(999),
            row(1001)
        ) {
            shouldThrowAny { Payment(it) }
        }
    }
})
