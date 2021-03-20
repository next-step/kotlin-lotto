package lotto

import lotto.domain.LottoPrize
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProfitTest {

    @Test
    fun `당첨된 로또가 없으면 수익률은 0이다`() {
        val profit = Profit(prizeRankCount = mapOf(Pair(LottoPrize.WHACK, 1)), purchaseAmount = 1000)
        val result = profit.rate()
        assertThat(result).isEqualTo(0.0)
    }
}
