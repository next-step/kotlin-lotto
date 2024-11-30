package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class MoneyTest : StringSpec({
    "금액이 0원 이하라면 IllegalArgumentException이 발생한다" {
        shouldThrow<IllegalArgumentException> {
            Money(-1)
        }
    }
})
