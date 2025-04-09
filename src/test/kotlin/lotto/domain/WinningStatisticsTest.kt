package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningStatisticsTest {
    @Test
    fun `set rate over 1`() {
        val winningStatistics = WinningStatistics(mutableMapOf(MatchPrize.FIFTH to 1, MatchPrize.FOURTH to 2))
        val rate = winningStatistics.yieldRate(10)
        assertThat(rate).isEqualTo(10.50)
    }

    @Test
    fun `set rate under 1`() {
        val winningStatistics = WinningStatistics(mutableMapOf(MatchPrize.FIFTH to 1))
        val rate = winningStatistics.yieldRate(30)
        assertThat(rate).isEqualTo(0.17)
    }
}
