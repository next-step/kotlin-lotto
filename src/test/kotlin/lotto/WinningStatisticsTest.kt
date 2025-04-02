package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class WinningStatisticsTest {
    @Test
    fun `Return profit rate 50 when cost is 1000 and rank is third`() {
        // given
        val rankCount = mutableMapOf(Rank.THIRD to 1)
        val profitCalculator = WinningStatistics(rankCount)
        val cost = 1000.0
        val expected = 50.0

        // when
        val actual = profitCalculator.calculateProfit(cost)

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `Return the count by rank`() {
        // given
        val rankCount =
            mutableMapOf(
                Rank.THIRD to 3,
                Rank.SECOND to 2,
                Rank.FIRST to 1,
            )
        val profitCalculator = WinningStatistics(rankCount)

        // when && then
        assertAll(
            { assertThat(profitCalculator.countBy(Rank.FIRST)).isEqualTo(1) },
            { assertThat(profitCalculator.countBy(Rank.SECOND)).isEqualTo(2) },
            { assertThat(profitCalculator.countBy(Rank.THIRD)).isEqualTo(3) },
            { assertThat(profitCalculator.countBy(Rank.FOURTH)).isEqualTo(0) },
        )
    }
}
