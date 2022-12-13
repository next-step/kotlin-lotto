package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import lotto.domain.MatchResult.FIFTH_PLACE
import lotto.domain.MatchResult.FIRST_PLACE
import lotto.domain.MatchResult.FOURTH_PLACE
import lotto.domain.MatchResult.NOT_WINNING
import lotto.domain.MatchResult.SECOND_PLACE
import lotto.domain.MatchResult.THIRD_PLACE

internal class MatchResultTest : StringSpec({
    "일치하는 개수를 이용하여 당첨 등수를 판별한다." {
        matchCounts.forAll { (matchCount: Int, expected: MatchResult) ->
            MatchResult.valueOf(matchCount, false) shouldBe expected
        }
    }

    "2등 당첨 여부를 판별한다." {
        val matchCount = 5
        secondPlaceCandidates.forAll { (containsBonusNumber: Boolean, expected: MatchResult) ->
            MatchResult.valueOf(matchCount, containsBonusNumber) shouldBe expected
        }
    }
}) {
    companion object {
        val matchCounts = listOf(
            6 to FIRST_PLACE,
            4 to FOURTH_PLACE,
            3 to FIFTH_PLACE,
            2 to NOT_WINNING,
            1 to NOT_WINNING,
            0 to NOT_WINNING,
        )

        val secondPlaceCandidates = listOf(
            true to SECOND_PLACE,
            false to THIRD_PLACE
        )
    }
}
