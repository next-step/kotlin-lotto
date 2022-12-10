package step2.lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import step2.lotto.domain.MatchResult.FIRST_PLACE
import step2.lotto.domain.MatchResult.FOURTH_PLACE
import step2.lotto.domain.MatchResult.NOT_WINNING
import step2.lotto.domain.MatchResult.SECOND_PLACE
import step2.lotto.domain.MatchResult.THIRD_PLACE

internal class MatchResultTest : StringSpec({
    "일치하는 개수를 이용하여 당첨 등수를 판별한다." {
        lotto.forAll { (matchCount: Int, expected: MatchResult) ->
            MatchResult.valueOf(matchCount) shouldBe expected
        }
    }
}) {
    companion object {
        val lotto = listOf(
            6 to FIRST_PLACE,
            5 to SECOND_PLACE,
            4 to THIRD_PLACE,
            3 to FOURTH_PLACE,
            2 to NOT_WINNING,
            1 to NOT_WINNING,
            0 to NOT_WINNING,
        )
    }
}
