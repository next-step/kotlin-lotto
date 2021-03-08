package lotto.domain

import lotto.enums.LotteryMatchType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningStatisticsTest {

    @Test
    fun `getMatchCount1 if nothing is inserted`() {
        val winningStatistics = WinningStatistics()

        assertThat(winningStatistics.getTicketCountOf(LotteryMatchType.Three)).isEqualTo(0)
    }

    @Test
    fun `addMatchCount and get test`() {
        val winningStatistics = WinningStatistics()
        winningStatistics.addTicketCountOf(LotteryMatchType.Four)
        assertThat(winningStatistics.getTicketCountOf(LotteryMatchType.Four)).isEqualTo(1)

        winningStatistics.addTicketCountOf(LotteryMatchType.Four)
        assertThat(winningStatistics.getTicketCountOf(LotteryMatchType.Four)).isEqualTo(2)
    }

    @Test
    fun `calculateTotalWinningPrice`() {
        val winningStatistics = WinningStatistics()
        winningStatistics.addTicketCountOf(LotteryMatchType.Four)
        winningStatistics.addTicketCountOf(LotteryMatchType.Five)
        winningStatistics.addTicketCountOf(LotteryMatchType.NonProfit)

        assertThat(winningStatistics.calculateTotalWinningPrice()).isEqualTo(1_550_000)

        winningStatistics.addTicketCountOf(LotteryMatchType.Three)
        assertThat(winningStatistics.calculateTotalWinningPrice()).isEqualTo(1_555_000)
    }
}
