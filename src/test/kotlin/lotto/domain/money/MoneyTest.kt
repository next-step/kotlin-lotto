package lotto.domain.money

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class MoneyTest : StringSpec({

    "음수가 주어지면 RuntimeException 예외 처리를 한다" {
        shouldThrow<RuntimeException> { Money(-1) }
    }

    "0은 돈으로 변환할 수 있다." {
        shouldNotThrow<Throwable> { Money(0) }
    }

    "양수는 돈으로 변환할 수 있다" {
        shouldNotThrow<Throwable> { Money(1) }
    }
})
