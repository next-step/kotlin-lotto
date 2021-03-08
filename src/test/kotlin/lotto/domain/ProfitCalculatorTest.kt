package lotto.domain

import lotto.enums.LotteryMatchType
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class ProfitCalculatorTest {

    @Test
    fun `calculate profit ratio`() {
        val winningStatistics = WinningStatistics()

        val calculateRatioZero = ProfitCalculator.calculateRatio(14000, winningStatistics)
        Assertions.assertThat(calculateRatioZero).isEqualTo(0.0)

        winningStatistics.addTicketCountOf(LotteryMatchType.Three)

//        val calculateRatioAfterAdd = ProfitCalculator.calculateRatio(14000, winningStatistics)
//        Assertions.assertThat(calculateRatioAfterAdd).isEqualTo(3.5)
    }
}
