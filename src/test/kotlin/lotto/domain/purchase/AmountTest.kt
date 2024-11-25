package lotto.domain.purchase

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class AmountTest : StringSpec({
    "수량은 음수가 되면 예외를 던진다" {
        shouldThrow<IllegalArgumentException> { Amount(-1) }
    }
})
