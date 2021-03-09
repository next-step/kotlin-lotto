package lotto.domain

import lotto.data.LotteryTicketNumber
import lotto.data.WinningNumbers
import lotto.domain.maker.TestLotteryTicketMaker
import lotto.enums.LotteryMatchType
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.entry
import org.junit.jupiter.api.Test

class LotteryTicketsTest {

    @Test
    fun `constructor`() {
        val lotteryTickets = LotteryTickets(14000)
        assertThat(lotteryTickets.lotteryTickets).hasSize(14)
    }

    @Test
    fun `createWinningStatics1`() {
        val winningNumbers = WinningNumbers(listOf(4, 5, 6, 7, 8, 9))

        val lotteryTickets = LotteryTickets(14000, TestLotteryTicketMaker())
        val winningStatics = lotteryTickets.createWinningStatics(winningNumbers)

        assertThat(winningStatics.ticketCounts).containsOnly(entry(LotteryMatchType.Three, 14))
    }

    @Test
    fun `createWinningStatics2`() {
        val winningNumbers = WinningNumbers(listOf(5, 6, 7, 8, 9, 10))

        val lotteryTickets = LotteryTickets(5000, TestLotteryTicketMaker())
        val winningStatics = lotteryTickets.createWinningStatics(winningNumbers)

        assertThat(winningStatics.ticketCounts).containsOnly(entry(LotteryMatchType.NonProfit, 5))
    }

    @Test
    fun `makeLotteryTicketNumberList test`() {
        val lotteryTickets = LotteryTickets(2000, TestLotteryTicketMaker())

        val expectLotteryTicketNumber = LotteryTicketNumber(listOf(1, 2, 3, 4, 5, 6))
        val actualLotteryTicketNumbers = lotteryTickets.makeLotteryTicketNumberList()
        assertThat(actualLotteryTicketNumbers).containsOnly(expectLotteryTicketNumber)
        assertThat(actualLotteryTicketNumbers).hasSize(2)
    }
}
