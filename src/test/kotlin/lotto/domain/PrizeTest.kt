package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class PrizeTest : FunSpec({
    context("prize calculation") {
        withData(
            6 to Prize.FIRST,
            5 to Prize.SECOND,
            4 to Prize.THIRD,
            3 to Prize.FOURTH,
            2 to Prize.NONE,
            1 to Prize.NONE,
            0 to Prize.NONE,
        ) { (matchCount, expected) ->
            Prize.calculate(matchCount) shouldBe expected
        }
    }
})
