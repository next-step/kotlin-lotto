package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RanksTest : StringSpec({
    "수익률 계산" {
        val ranks = Ranks(listOf(Rank.FOURTH))
        ranks.rateOfReturn(14_000) shouldBe 0.35
    }

    "순위 갯수" {
        val ranks =
            Ranks(listOf(Rank.FIRST, Rank.FIRST, Rank.FIRST, Rank.FIRST, Rank.FIRST, Rank.FIRST))
        ranks.count(Rank.FIRST) shouldBe 6
    }
})