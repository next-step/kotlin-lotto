package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RanksTest : StringSpec({
    "수익률 계산" {
        val ranks = Ranks(listOf(Rank.FOURTH))
        ranks.rateOfReturn(14_000) shouldBe 0.35
    }
})