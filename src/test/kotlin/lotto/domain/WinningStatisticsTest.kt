package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningStatisticsTest {

    @Test
    fun `getMatchCount1 if nothing is inserted`() {
        val winningStatistics = WinningStatistics()

        assertThat(winningStatistics.getMatchNumberCount(3)).isEqualTo(0)
    }

    @Test
    fun `addMatchCount and get test`() {
        val winningStatistics = WinningStatistics()
        winningStatistics.addMatchNumberCount(4)
        assertThat(winningStatistics.getMatchNumberCount(4)).isEqualTo(1)

        winningStatistics.addMatchNumberCount(4)
        assertThat(winningStatistics.getMatchNumberCount(4)).isEqualTo(2)
    }
}