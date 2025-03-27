package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData

class AmountTest : FunSpec({
    context("value must be above or equal to 1,000 and below or equal to 100,000") {
        withData(
            1_000,
            2_000,
            10_000,
            100_000,
        ) {
            shouldNotThrowAny {
                Amount(it)
            }
        }
    }
})
