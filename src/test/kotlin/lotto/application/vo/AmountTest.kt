package lotto.application.vo

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class AmountTest : StringSpec({
    "구입 금액을 생성할수 있다" {
        shouldNotThrow<Throwable> { Amount(1_000) }
    }

    "구입 금액이 0원 미만일 경우 Exception을 던진다" {
        shouldThrow<IllegalArgumentException> { Amount(-1) }
    }

    "구입 금액을 더할수 있다" {
        val amount1 = Amount(100)
        val amount2 = Amount(100)

        amount1 + amount2 shouldBe Amount(amount1.value + amount2.value)
    }
})
