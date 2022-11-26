package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class WinningStatisticsTest : BehaviorSpec({
    val winningStatistics = WinningStatistics()

    given("로또를 5장 구매했을 때") {
        `when`("4장이 3개의 수가 일치하면") {
            val matches = listOf(3, 3, 3, 3, 1)
            val result = winningStatistics.add(matches)

            then("당첨 통계의 4등의 카운트는 4이다.") {
                result.getNumberOfMatchCount(Rank.FOURTH) shouldBe 4
            }

            then("당첨금이 없는 수의 개수는 무시하므로 전체 카운트는 4다.") {
                var sum = result.getNumberOfMatchCount(Rank.FOURTH)
                sum += result.getNumberOfMatchCount(Rank.THIRD)
                sum += result.getNumberOfMatchCount(Rank.SECOND)
                sum += result.getNumberOfMatchCount(Rank.FIRST)
                sum shouldBe 4
            }
        }
    }
})
