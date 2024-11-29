import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.WinningCategory
import lotto.domain.WinningStatistics

class WinningStatisticsTest : StringSpec({
    "should calculate total prize from statistics" {
        val statistics =
            mapOf(
                WinningCategory.FIFTH to 2,
                WinningCategory.FOURTH to 1,
                WinningCategory.SECOND to 1,
            )
        val winningStatistics = WinningStatistics(statistics)
        val totalPrize = winningStatistics.calculateTotalPrize()
        totalPrize shouldBe (5000 * 2 + 50000 * 1 + 30000000 * 1)
    }

    "should return statistics as is" {
        val statistics =
            mapOf(
                WinningCategory.THIRD to 3,
                WinningCategory.FIRST to 1,
            )
        val winningStatistics = WinningStatistics(statistics)
        val result = winningStatistics.getStatistics()
        result shouldBe statistics
    }
})
