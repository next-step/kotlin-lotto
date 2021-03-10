package lotto.domain

import lotto.enums.LotteryMatchType
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class ProfitCalculatorTest {

    @Test
    fun `calculate profit ratio`() {
        val winningStatistics = WinningStatistics()

        val calculateRatioZero = ProfitCalculator.calculateRatio(14000, winningStatistics)
        Assertions.assertThat(calculateRatioZero).isEqualTo(BigDecimal("0.00"))

        winningStatistics.addTicketOf(LotteryMatchType.Three)

        val calculateRatioAfterAdd = ProfitCalculator.calculateRatio(14000, winningStatistics)
        Assertions.assertThat(calculateRatioAfterAdd).isEqualTo(BigDecimal("0.35"))
    }
}
