package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class ProfitCalculatorTest {
    @Test
    fun `수익 계산`() {

        val profitCalculator = ProfitCalculator()

        val prizeStat = Pair(PrizeMoney.THREE, 1)
        val profit = profitCalculator.calculateProfit(listOf(prizeStat))

        Assertions.assertThat(profit.money).isEqualTo(PrizeMoney.THREE.money)
    }
}
