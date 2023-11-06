package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class AmountTest : StringSpec({
    "로또 구입 금액은 1000원 단위로 입력한다." {
        Amount(1000)
    }

    "로또 구입 금액은 1000원 단위가 아니면 예외가 발생한다." {
        shouldThrow<IllegalArgumentException> {
            Amount(1001)
        }
    }
})
