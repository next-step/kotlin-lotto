package lottery.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class RankCountsTest {

    @Test
    fun `맞춘 개수에 맞는 등수에 건수를 증가시킨다`() {
        val rankCounts = RankCounts()
        val first = Rank.FIRST
        val second = Rank.SECOND
        val third = Rank.THIRD

        rankCounts.addMatchCount(first)
        rankCounts.addMatchCount(first)
        rankCounts.addMatchCount(second)
        rankCounts.addMatchCount(third)

        assertAll(
            { assertThat(rankCounts.rankCounts[first]).isEqualTo(2) },
            { assertThat(rankCounts.rankCounts[second]).isEqualTo(1) },
            { assertThat(rankCounts.rankCounts[third]).isEqualTo(1) }
        )
    }
}
