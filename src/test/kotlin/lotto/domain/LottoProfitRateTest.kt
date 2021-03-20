package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoProfitRateTest {
    @Test
    fun `수익률 계산`() {
        val lottoProfitRate = LottoProfitRate(14000, LottoPrice(14000))
        assertThat(lottoProfitRate.value).isEqualTo(1.0)
    }
}
