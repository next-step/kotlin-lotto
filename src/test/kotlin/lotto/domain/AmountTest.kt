package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll

class AmountTest : FunSpec({
    test("value must be above or equal to 1,000 and below or equal to 100,000") {
        listOf(
            1_000,
            2_000,
            10_000,
            100_000,
        ).forAll {
            shouldNotThrowAny {
                Amount(it)
            }
        }
    }

    test("throw exception if value is less than 1,000 or above 100,000") {
        listOf(
            998,
            999,
            100_001,
            100_002,
        ).forAll {
            shouldThrow<IllegalArgumentException> {
                Amount(it)
            }
        }
    }
})
