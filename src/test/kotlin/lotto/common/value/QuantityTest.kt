package lotto.common.value

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec

class QuantityTest : FreeSpec({
    "수량은 음수로 생성할 수 없다" {
        val value = -100L
        shouldThrow<IllegalArgumentException> { Quantity(value = value) }
    }
})
