package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProfitCalculatorTest {

    @Test
    fun `수익률이 반환됩니다`() {
        val profitCalculator = ProfitCalculator()

        val result = profitCalculator.calculateProfit(listOf(Reward.FOURTH_RANK), 1000)

        assertThat(result).isEqualTo((5000 - 1000) / 1000.toFloat())
    }
}
