package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class PrizeTest : FunSpec({
    context("prize calculation") {
        withData(
            (6 to false) to Prize.FIRST,
            (5 to true) to Prize.SECOND,
            (5 to false) to Prize.THIRD,
            (4 to false) to Prize.FOURTH,
            (4 to true) to Prize.FOURTH,
            (3 to false) to Prize.FIFTH,
            (2 to false) to Prize.NONE,
            (1 to false) to Prize.NONE,
            (0 to false) to Prize.NONE,
        ) { (countWithHasBonus, expected) ->
            val (matchCount, hasBonus) = countWithHasBonus
            Prize.calculate(matchCount, hasBonus) shouldBe expected
        }
    }
})
