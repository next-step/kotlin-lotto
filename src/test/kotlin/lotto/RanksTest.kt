package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Rank
import lotto.domain.Ranks

class RanksTest : StringSpec({
    "수익률 계산" {
        val ranks = Ranks(listOf(Rank.FOURTH))
        ranks.rateOfReturn(14_000) shouldBe 0.35
    }

    "순위 갯수" {
        val ranks =
            Ranks(listOf(Rank.FIRST, Rank.FIRST, Rank.FIRST, Rank.FIRST, Rank.FIRST, Rank.FIRST))
        ranks.ranks[Rank.FIRST] shouldBe 6
    }
})
