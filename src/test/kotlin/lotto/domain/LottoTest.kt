package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class LottoTest : StringSpec({
    "should fail when Lotto contains invalid numbers" {
        shouldThrow<IllegalArgumentException> {
            Lotto.of(listOf(0, 55, 36, 77))
        }
    }
})
