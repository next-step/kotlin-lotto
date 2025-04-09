package lotto.domain

import lotto.controller.WinningNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningStatisticsCalculatorTest {
    @Test
    fun `calculate winning statistics`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)
        val tickets = Tickets(
            listOf(
                Ticket(listOf(1, 2, 3, 4, 5, 6)),
                Ticket(listOf(1, 2, 3, 10, 11, 12)),
                Ticket(listOf(13, 14, 15, 16, 17, 18))
            )
        )
        val (winningStatistics, rate) = WinningStatisticsCalculator().calculate(winningNumbers, tickets)
        assertThat(winningStatistics.get(1, false)).isEqualTo(0)
        assertThat(winningStatistics.get(2, false)).isEqualTo(0)
        assertThat(winningStatistics.get(3, false)).isEqualTo(1)
        assertThat(winningStatistics.get(4, false)).isEqualTo(0)
        assertThat(winningStatistics.get(5, false)).isEqualTo(0)
        assertThat(winningStatistics.get(5, true)).isEqualTo(0)
        assertThat(winningStatistics.get(6, false)).isEqualTo(1)
        assertThat(rate).isEqualTo(666_666_8.33)
    }

    @Test
    fun `calculate winning statistics including bonus number`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)
        val tickets = Tickets(
            listOf(
                Ticket(listOf(1, 2, 3, 4, 5, 7)),
                Ticket(listOf(1, 2, 3, 10, 11, 12)),
                Ticket(listOf(13, 14, 15, 16, 17, 18))
            )
        )
        val (winningStatistics, rate) = WinningStatisticsCalculator().calculate(winningNumbers, tickets)
        assertThat(winningStatistics.get(1, false)).isEqualTo(0)
        assertThat(winningStatistics.get(2, false)).isEqualTo(0)
        assertThat(winningStatistics.get(3, false)).isEqualTo(1)
        assertThat(winningStatistics.get(4, false)).isEqualTo(0)
        assertThat(winningStatistics.get(5, false)).isEqualTo(0)
        assertThat(winningStatistics.get(5, true)).isEqualTo(1)
        assertThat(winningStatistics.get(6, false)).isEqualTo(0)
        assertThat(rate).isEqualTo(10_001.67)
    }
}
