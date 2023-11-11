package lotto.business

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LotteryStatisticsGeneratorTest {

    @Test
    fun `받은 금액과 비교하여 수익률을 계산한다`() {
        // given
        val prizeResults = PrizeResults(
            mapOf(
                LotteryPrize.FIFTH to 5,
                LotteryPrize.FOURTH to 4,
                LotteryPrize.THIRD to 3,
                LotteryPrize.FIRST to 1
            )
        )
        val receivedAmount = ReceivedAmount(100000000)
        val expected = ProfitRate(20.04725)

        // when
        val profitRate = prizeResults.calculateProfitRate(receivedAmount)

        // then
        assertThat(profitRate).isEqualTo(expected)
    }
}
