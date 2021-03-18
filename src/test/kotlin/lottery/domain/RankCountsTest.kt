package lottery.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class RankCountsTest {
    @Test
    fun `맞춘 개수에 맞는 등수에 건수를 증가시킨다`() {
        val rankCounts = createRankCounts()

        assertAll(
            { assertThat(rankCounts.rankCounts[Rank.FIRST]).isEqualTo(2) },
            { assertThat(rankCounts.rankCounts[Rank.THIRD]).isEqualTo(1) },
            { assertThat(rankCounts.rankCounts[Rank.FOURTH]).isEqualTo(1) }
        )
    }

    @Test
    fun `모든 등수의 당첨금들 합을 가져온다`() {
        val rankCounts = createRankCounts()

        val amount = rankCounts.calculateJackpots()

        assertThat(amount).isEqualTo((Rank.FIRST.price * 2) + Rank.THIRD.price + Rank.FOURTH.price)
    }

    private fun createRankCounts(): RankCounts {
        val rankCounts = RankCounts()
        val first = Rank.FIRST
        val second = Rank.THIRD
        val third = Rank.FOURTH

        rankCounts.addMatchCount(first)
        rankCounts.addMatchCount(first)
        rankCounts.addMatchCount(second)
        rankCounts.addMatchCount(third)

        return rankCounts
    }
}
