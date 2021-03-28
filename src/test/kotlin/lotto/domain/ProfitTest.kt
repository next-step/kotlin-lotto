package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProfitTest {

    @Test
    fun `당첨된 로또가 없으면 수익률은 0이다`() {
        val prizeRankCount = mapOf(LottoPrize.WHACK to PositiveNumber(1))
        val purchaseAmount = Money(1000)
        val profit = Profit(prizeRankCount = prizeRankCount, purchaseAmount = purchaseAmount)

        val result = profit.rate()

        assertThat(result).isEqualTo(0.0)
    }
}
