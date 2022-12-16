package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

internal class WinningAmountTest : StringSpec({
    "로또 당첨 개수에 해당하지 않으면 Exception을 던진다." {
        shouldThrow<IllegalArgumentException> {
            WinningAmount.from(7)
        }
    }
})
