package lottery

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class MoneyTest : StringSpec({
    "금액이 0 미만일시 예외 발생한다" {
        shouldThrow<IllegalArgumentException> { Money(-1000) }
    }

    "나누는 금액이 0 일시 예외 발생한다" {
        shouldThrow<IllegalArgumentException> { Money(1000).divideBy(Money(0)) }
    }
})
