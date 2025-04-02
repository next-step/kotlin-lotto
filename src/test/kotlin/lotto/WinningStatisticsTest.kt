package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningStatisticsTest {
    @Test
    fun `Return profit rate 50 when cost is 1000 and rank is third`() {
        // given
        val profitCalculator = WinningStatistics()
        profitCalculator.addRank(Rank.THIRD)
        val cost = 1000.0
        val expected = 50.0

        // when
        val actual = profitCalculator.calculateProfit(cost)

        // then
        assertThat(actual).isEqualTo(expected)
    }
}
