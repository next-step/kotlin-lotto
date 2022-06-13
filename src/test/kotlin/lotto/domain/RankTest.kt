package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.row
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class RankTest : StringSpec({
    "일치하는 갯수와 일치하는 등수를 찾는다" {
        listOf(
            row(6, false, Rank.FIRST),
            row(5, true, Rank.SECOND),
            row(5, false, Rank.THIRD),
            row(4, false, Rank.FOURTH),
            row(3, false, Rank.FIFTH),
            row(2, false, Rank.NONE),
            row(1, false, Rank.NONE),
            row(0, false, Rank.NONE),
        ).forAll { (correctNumber, isMatchedBonusBall, expected) ->
            // when
            val actual = Rank.of(correctNumber, isMatchedBonusBall)

            // then
            actual shouldBe expected
        }
    }
})
