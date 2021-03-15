package lotto.domain

import lotto.data.WinningNumbers
import lotto.domain.maker.TestLotteryTicketMaker
import lotto.enums.LotteryMatchType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BuyerTest {

    @Test
    fun `로또를 구매한 경우, 티켓 개수를 확인한다`() {
        val buyer = Buyer()
        val tickets = buyer.buyLotteryTickets(2000, TestLotteryTicketMaker())

        assertThat(tickets).hasSize(2)
    }

    @Test
    fun `2000원으로 구매한 경우, 4개를 맞춘 로또 2장의 winningStatics를 만든다`() {
        val buyer = Buyer()
        buyer.buyLotteryTickets(2000, TestLotteryTicketMaker())

        val winningNumbers = WinningNumbers(listOf(3, 4, 5, 6, 7, 8), 45)
        val winningStatistics = buyer.createWinningStatics(winningNumbers)

        assertThat(winningStatistics.getTicketCountOf(LotteryMatchType.Four)).isEqualTo(2)
    }

    @Test
    fun `4000원으로 구매한 경우, 3개를 맞춘 로또 4장의 winningStatics를 만든다`() {
        val buyer = Buyer()
        buyer.buyLotteryTickets(4000, TestLotteryTicketMaker())

        val winningNumbers = WinningNumbers(listOf(4, 5, 6, 7, 8, 9), 45)
        val winningStatistics = buyer.createWinningStatics(winningNumbers)

        assertThat(winningStatistics.getTicketCountOf(LotteryMatchType.Three)).isEqualTo(4)
    }

    @Test
    fun `1000원으로 구매한 경우, 5개와 보너스 번호를 맞춘 로또 1장의 winningStatics를 만든다`() {
        val buyer = Buyer()
        buyer.buyLotteryTickets(1000, TestLotteryTicketMaker())

        val winningNumbers = WinningNumbers(listOf(2, 3, 4, 5, 6, 7), 1)
        val winningStatistics = buyer.createWinningStatics(winningNumbers)

        assertThat(winningStatistics.getTicketCountOf(LotteryMatchType.FiveWithBonus)).isEqualTo(1)
    }
}
