import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.PurchaseAmount
import lotto.domain.WinningCategory
import lotto.domain.WinningStatistics

class WinningStatisticsTest : StringSpec({

    "should evaluate tickets and calculate correct statistics" {
        val winningCategories =
            listOf(
                WinningCategory.FOURTH,
                WinningCategory.THIRD,
                WinningCategory.SECOND,
                WinningCategory.FIRST,
                WinningCategory.NONE,
            )

        val statistics = WinningStatistics(winningCategories)
        val result = statistics.getStatistics()

        result[WinningCategory.FOURTH] shouldBe 1
        result[WinningCategory.THIRD] shouldBe 1
        result[WinningCategory.SECOND] shouldBe 1
        result[WinningCategory.FIRST] shouldBe 1
        result[WinningCategory.NONE] shouldBe 1
    }

    "should calculate total prize from statistics" {
        val winningCategories =
            listOf(
                WinningCategory.FOURTH,
                WinningCategory.SECOND,
                WinningCategory.SECOND,
            )

        val statistics = WinningStatistics(winningCategories)
        val totalPrize = statistics.calculateTotalPrize()

        totalPrize shouldBe (50_000 * 1 + 30_000_000 * 2)
    }

    "should calculate profit rate correctly" {
        val winningCategories =
            listOf(
                WinningCategory.FOURTH,
                WinningCategory.SECOND,
            )

        val statistics = WinningStatistics(winningCategories)
        val profitRate = statistics.calculateProfitRate(PurchaseAmount(2_000))

        profitRate shouldBe ((50_000 + 30_000_000).toDouble() / 2000)
    }
})
