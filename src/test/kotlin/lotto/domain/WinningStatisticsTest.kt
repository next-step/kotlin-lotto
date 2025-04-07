package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningStatisticsTest {
    @Test
    fun `set rate over 1`() {
        val winningStatistics = WinningStatistics(mutableMapOf(3 to 1, 4 to 2))
        winningStatistics.yieldRate(10)
        assertThat(winningStatistics.getRate()).isEqualTo(10.50)
    }

    @Test
    fun `set rate under 1`() {
        val winningStatistics = WinningStatistics(mutableMapOf(3 to 1))
        winningStatistics.yieldRate(30)
        assertThat(winningStatistics.getRate()).isEqualTo(0.17)
    }
}
