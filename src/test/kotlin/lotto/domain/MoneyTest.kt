package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class MoneyTest: StringSpec() {
    init {
        "돈은 0 또는 양수만 가능하다" {
            shouldNotThrowAny {
                Money(0)
                Money(1000)
            }
        }

        "음수는 불가능하다" {
            shouldThrow<IllegalArgumentException> {
                Money(-1)
            }
        }
    }
}
