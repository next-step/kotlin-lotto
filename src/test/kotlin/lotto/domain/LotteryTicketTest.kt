package lotto.domain

import lotto.data.WinningNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LotteryTicketTest {
    @Test
    fun `constructor test`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotteryTicket = LotteryTicket(numbers)
        assertThat(lotteryTicket.numbers).containsAll(numbers)
    }

    @Test
    fun `findMatchCount1 test`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val winningNumbers = WinningNumbers(listOf(4, 5, 6, 7, 8, 9))
        val lotteryTicket = LotteryTicket(numbers)

        assertThat(lotteryTicket.findMatchCount(winningNumbers)).isEqualTo(3)
    }

    @Test
    fun `findMatchCount2 test`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val winningNumbers = WinningNumbers(listOf(5, 6, 7, 8, 9, 10))
        val lotteryTicket = LotteryTicket(numbers)

        assertThat(lotteryTicket.findMatchCount(winningNumbers)).isEqualTo(2)
    }

    @Test
    fun `findMatchCount3 test`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val winningNumbers = WinningNumbers(listOf(7, 8, 9, 10, 11, 12))
        val lotteryTicket = LotteryTicket(numbers)

        assertThat(lotteryTicket.findMatchCount(winningNumbers)).isEqualTo(0)
    }
}
