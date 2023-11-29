package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RankResultTest : StringSpec({
    "Rank result should show correct prize" {
        RankResult(
            mapOf (
                Rank.FirstPlace to 1,
                Rank.SecondPlace to 2,
                Rank.ThirdPlace to 3,
                Rank.FourthPlace to 4,
                Rank.FifthPlace to 5,
                Rank.LastPlace to 6,
            )
        ).totalPrize() shouldBe 2_010_725_000
    }
})
