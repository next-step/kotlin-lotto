package lotto

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test

internal class StatisticsTest {
    @Test
    fun `통계 값(3이상 6이하)이 존재하면 1을 더한다`() {
        val statistics = Statistics()
        statistics.statistic[Rank.FIVE] = 0

        statistics.add(Rank.FIVE)

        assertThat(statistics.statistic[Rank.FIVE] == 1)
    }

    @Test
    fun `5등 통계값을 계산한다`() {
        // given
        val statistics = Statistics()
        statistics.statistic[Rank.FIVE] = 1 // 3개는 5000원

        // when
        val result = statistics.statistic(3000)

        // then
        assertThat(result == 0.6)
    }
}
