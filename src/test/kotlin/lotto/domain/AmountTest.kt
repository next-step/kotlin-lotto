package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ExpectSpec

class AmountTest : ExpectSpec({

    expect("0보다 작은 수를 입력하면 예외가 발생한다.") {
        shouldThrow<IllegalArgumentException> {
            Amount(-1) + Amount(-1)
        }
    }
})
