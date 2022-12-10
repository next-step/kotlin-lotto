package step2.lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import step2.lotto.domain.MatchResult.THIRD_PLACE

internal class PlayResultsTest : StringSpec({
    "등수별 당첨 수 및 수익률의 당첨 통계 정보를 산출한다." {
        val given = PlayResults()
        val lotto = Lotto.of(setOf(1, 2, 3, 4, 5, 6))
        given.add(lotto, THIRD_PLACE)

        given.totalReward shouldBe THIRD_PLACE.reward
        given.thirdPlaceCount shouldBe 1
        given.calculateProfitRate(1_000) shouldBe 50.0
    }
})
