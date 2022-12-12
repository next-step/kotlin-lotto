package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.MatchResult.THIRD_PLACE

internal class PlayResultsTest : StringSpec({
    "등수별 당첨 수 및 수익률의 당첨 통계 정보를 산출한다." {
        val given = PlayResults.of(MatchResults.of(listOf(THIRD_PLACE)), 1_000)

        given.totalReward shouldBe THIRD_PLACE.reward
        given[THIRD_PLACE] shouldBe 1
        given.profitRate shouldBe 50.0
    }
})
