package lotto.domain

import lotto.data.BuyingData
import lotto.data.LottoNumbers
import lotto.data.WinningNumbers
import lotto.domain.maker.TestLotteryTicketMaker
import lotto.enums.LotteryMatchType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BuyerTest {

    @Test
    fun `로또를 구매한 경우, 티켓 개수를 확인한다`() {
        val buyer = Buyer()
        val tickets = buyer.buyLotteryTickets(BuyingData(2000, emptyList()), TestLotteryTicketMaker())

        assertThat(tickets).hasSize(2)
    }

    @Test
    fun `로또를 구매한 경우, 수동 입력한 로또 번호가 포함되어 있는지 확인한`() {
        val buyer = Buyer()
        val lottoNumbersList = listOf(LottoNumbers(listOf(11, 12, 13, 14, 15, 16)))
        val buyingData = BuyingData(1000, lottoNumbersList)
        val tickets = buyer.buyLotteryTickets(buyingData, TestLotteryTicketMaker())

        assertThat(tickets).hasSize(1)
        assertThat(tickets[0].lottoNumbers.lottoNumbers).extracting("lottoNumber").containsExactly(11, 12, 13, 14, 15, 16)
    }

    @Test
    fun `2000원으로 구매한 경우, 4개를 맞춘 로또 2장의 winningStatics를 만든다`() {
        val buyer = Buyer()
        buyer.buyLotteryTickets(BuyingData(2000, emptyList()), TestLotteryTicketMaker())

        val winningNumbers = WinningNumbers(listOf(3, 4, 5, 6, 7, 8), 45)
        val winningStatistics = buyer.createWinningStatics(winningNumbers)

        assertThat(winningStatistics.getTicketCountOf(LotteryMatchType.Four)).isEqualTo(2)
    }

    @Test
    fun `4000원으로 구매한 경우, 3개를 맞춘 로또 4장의 winningStatics를 만든다`() {
        val buyer = Buyer()
        buyer.buyLotteryTickets(BuyingData(4000, emptyList()), TestLotteryTicketMaker())

        val winningNumbers = WinningNumbers(listOf(4, 5, 6, 7, 8, 9), 45)
        val winningStatistics = buyer.createWinningStatics(winningNumbers)

        assertThat(winningStatistics.getTicketCountOf(LotteryMatchType.Three)).isEqualTo(4)
    }

    @Test
    fun `1000원으로 구매한 경우, 5개와 보너스 번호를 맞춘 로또 1장의 winningStatics를 만든다`() {
        val buyer = Buyer()
        buyer.buyLotteryTickets(BuyingData(1000, emptyList()), TestLotteryTicketMaker())

        val winningNumbers = WinningNumbers(listOf(2, 3, 4, 5, 6, 7), 1)
        val winningStatistics = buyer.createWinningStatics(winningNumbers)

        assertThat(winningStatistics.getTicketCountOf(LotteryMatchType.FiveWithBonus)).isEqualTo(1)
    }
}
