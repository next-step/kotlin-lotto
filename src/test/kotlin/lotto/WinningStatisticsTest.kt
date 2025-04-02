package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

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

    @Test
    fun `Return the count by rank`() {
        // given
        val profitCalculator = WinningStatistics()
        profitCalculator.addRank(Rank.FIRST)
        profitCalculator.addRank(Rank.SECOND)
        profitCalculator.addRank(Rank.SECOND)
        profitCalculator.addRank(Rank.THIRD)
        profitCalculator.addRank(Rank.THIRD)
        profitCalculator.addRank(Rank.THIRD)

        // when && then
        assertAll(
            { assertThat(profitCalculator.countBy(Rank.FIRST)).isEqualTo(1) },
            { assertThat(profitCalculator.countBy(Rank.SECOND)).isEqualTo(2) },
            { assertThat(profitCalculator.countBy(Rank.THIRD)).isEqualTo(3) },
            { assertThat(profitCalculator.countBy(Rank.FOURTH)).isEqualTo(0) },
        )
    }
}
