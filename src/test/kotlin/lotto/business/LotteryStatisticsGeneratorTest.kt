package lotto.business

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

private const val i = 1

class LotteryStatisticsGeneratorTest {

    @Test
    fun `매칭 결과 가져와서 통계 결과를 만든다`() {
        // given
        val lottoTicketManager = LottoTicketManager()
        val lottoTicket1 = lottoTicket(1, 2, 3, 4, 5, 6)
        val lottoTicket2 = lottoTicket(1, 2, 3, 4, 5, 7)
        val lottoTicket3 = lottoTicket(1, 2, 3, 4, 7, 8)
        val lottoTicket4 = lottoTicket(1, 2, 3, 7, 8, 9)
        val lottoTicket5 = lottoTicket(1, 2, 7, 8, 9, 10)
        val lottoTicket6 = lottoTicket(1, 7, 8, 9, 10, 11)
        lottoTicketManager.addAll(
            listOf(
                lottoTicket1,
                lottoTicket2,
                lottoTicket3,
                lottoTicket4,
                lottoTicket5,
                lottoTicket6
            )
        )
        val winningNumbers = lottoWinningNumbers(1,2,3,4,5,6)
        val calculatedResults = lottoTicketManager.compilePrizeResults(winningNumbers)
        val lotteryStatisticsGenerator = LotteryStatisticsGenerator()

        // when
        val lotteryStatistics = lotteryStatisticsGenerator.generate(calculatedResults)

        // then
        assertAll(
            { assertThat(lotteryStatistics.treeMatchCount).isEqualTo(1) },
            { assertThat(lotteryStatistics.fourMatchCount).isEqualTo(1) },
            { assertThat(lotteryStatistics.fiveMatchCount).isEqualTo(1) },
            { assertThat(lotteryStatistics.sixMatchCount).isEqualTo(1) }
        )
    }

    private fun lottoWinningNumbers(num1: Int,num2: Int,num3: Int,num4: Int,num5: Int,num6: Int) = LottoWinningNumbers(
        listOf(
            LottoNumber(num1),
            LottoNumber(num2),
            LottoNumber(num3),
            LottoNumber(num4),
            LottoNumber(num5),
            LottoNumber(num6)
        )
    )

    private fun lottoTicket(num1: Int, num2: Int, num3: Int, num4: Int, num5: Int, num6: Int) = LottoTicket(
        listOf(
            LottoNumber(num1),
            LottoNumber(num2),
            LottoNumber(num3),
            LottoNumber(num4),
            LottoNumber(num5),
            LottoNumber(num6)
        )
    )

    @Test
    fun `받은 금액과 비교하여 수익률을 계산한다`() {
        // given
        val prizeResults = PrizeResults(
            mapOf(
                LotteryPrize.THREE_MATCH to 5,
                LotteryPrize.FOUR_MATCH to 4,
                LotteryPrize.FIVE_MATCH to 3,
                LotteryPrize.SIX_MATCH to 1
            )
        )
        val receivedAmount = ReceivedAmount(100000000)
        val expected = ProfitRate(20.04725)
        val lotteryStatisticsGenerator = LotteryStatisticsGenerator()

        // when
        val profitRate = lotteryStatisticsGenerator.calculateProfitRate(receivedAmount, prizeResults)

        // then
        assertThat(profitRate).isEqualTo(expected)
    }
}
