package lotto.domain

import lotto.data.WinningNumbers
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.entry
import org.junit.jupiter.api.Test

class LotteryTicketsTest {

    @Test
    fun `constructor`() {
        val lotteryTickets = LotteryTickets(14)
        Assertions.assertThat(lotteryTickets.lotteryTickets).hasSize(14)
    }

    @Test
    fun `createWinningStatics1`() {
        val winningNumbers = WinningNumbers(listOf(4, 5, 6, 7, 8, 9))

        val lotteryTickets = LotteryTickets(14, TestLotteryTicketMaker())
        val winningStatics = lotteryTickets.createWinningStatics(winningNumbers)

        Assertions.assertThat(winningStatics.matchNumberCounts).containsOnly(entry(3, 14))
    }

    @Test
    fun `createWinningStatics2`() {
        val winningNumbers = WinningNumbers(listOf(5, 6, 7, 8, 9, 10))

        val lotteryTickets = LotteryTickets(5, TestLotteryTicketMaker())
        val winningStatics = lotteryTickets.createWinningStatics(winningNumbers)

        Assertions.assertThat(winningStatics.matchNumberCounts).containsOnly(entry(2, 5))
    }
}
