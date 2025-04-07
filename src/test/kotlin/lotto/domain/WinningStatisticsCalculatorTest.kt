package lotto.domain

import lotto.controller.WinningNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningStatisticsCalculatorTest {
    @Test
    fun `calculate winning statistics`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6))
        val tickets = Tickets(
            listOf(
                Ticket(listOf(1, 2, 3, 4, 5, 6)),
                Ticket(listOf(1, 2, 3, 10, 11, 12)),
                Ticket(listOf(13, 14, 15, 16, 17, 18))
            )
        )
        val (winningStatistics, rate) = WinningStatisticsCalculator().calculate(winningNumbers, tickets)
        assertThat(winningStatistics.get(1)).isEqualTo(0)
        assertThat(winningStatistics.get(2)).isEqualTo(0)
        assertThat(winningStatistics.get(3)).isEqualTo(1)
        assertThat(winningStatistics.get(4)).isEqualTo(0)
        assertThat(winningStatistics.get(5)).isEqualTo(0)
        assertThat(winningStatistics.get(6)).isEqualTo(1)
        assertThat(rate).isEqualTo(666_666_8.33)
    }
}
