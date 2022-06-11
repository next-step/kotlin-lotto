package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.row
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class RankTest : StringSpec({
    "일치하는 갯수와 일치하는 등수를 찾는다" {
        listOf(
            row(6, Rank.FIRST),
            row(5, Rank.SECOND),
            row(4, Rank.THIRD),
            row(3, Rank.FOURTH),
            row(2, Rank.NONE),
            row(1, Rank.NONE),
            row(0, Rank.NONE),
        ).forAll { (correctNumber, expected) ->
            // when
            val actual = Rank.of(correctNumber)

            // then
            actual shouldBe expected
        }
    }
})
