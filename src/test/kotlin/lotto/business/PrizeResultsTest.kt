package lotto.business

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PrizeResultsTest{
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

        // when
        val profitRate = prizeResults.calculateProfitRate(receivedAmount)

        // then
        assertThat(profitRate).isEqualTo(expected)
    }
}
