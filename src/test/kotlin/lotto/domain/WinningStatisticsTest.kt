import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoTickets
import lotto.domain.PurchaseAmount
import lotto.domain.WinningCategory
import lotto.domain.WinningLotto
import lotto.domain.WinningStatistics

class WinningStatisticsTest : StringSpec({
    "should evaluate tickets and calculate correct statistics" {
        val winningNumbers = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoNumber.of(7)
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)

        val tickets =
            LottoTickets(
                listOf(
                    Lotto.of(listOf(1, 2, 3, 4, 8, 9)),
                    Lotto.of(listOf(1, 2, 3, 4, 5, 9)),
                    Lotto.of(listOf(1, 2, 3, 4, 5, 7)),
                    Lotto.of(listOf(1, 2, 3, 4, 5, 6)),
                    Lotto.of(listOf(8, 9, 10, 11, 12, 13)),
                ),
            )

        val statistics = WinningStatistics(tickets, winningLotto)
        val result = statistics.getStatistics()

        result[WinningCategory.FOURTH] shouldBe 1
        result[WinningCategory.THIRD] shouldBe 1
        result[WinningCategory.SECOND] shouldBe 1
        result[WinningCategory.FIRST] shouldBe 1
        result[WinningCategory.NONE] shouldBe 1
    }

    "should calculate total prize from statistics" {
        val winningNumbers = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoNumber.of(7)
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)

        val tickets =
            LottoTickets(
                listOf(
                    Lotto.of(listOf(1, 2, 3, 4, 8, 9)),
                    Lotto.of(listOf(1, 2, 3, 4, 5, 7)),
                    Lotto.of(listOf(1, 2, 3, 4, 5, 7)),
                ),
            )

        val statistics = WinningStatistics(tickets, winningLotto)
        val totalPrize = statistics.calculateTotalPrize()

        totalPrize shouldBe (50_000 * 1 + 30_000_000 * 2)
    }

    "should calculate profit rate correctly" {
        val winningNumbers = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoNumber.of(7)
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)

        val tickets =
            LottoTickets(
                listOf(
                    Lotto.of(listOf(1, 2, 3, 4, 8, 9)),
                    Lotto.of(listOf(1, 2, 3, 4, 5, 7)),
                ),
            )

        val statistics = WinningStatistics(tickets, winningLotto)
        val profitRate = statistics.calculateProfitRate(PurchaseAmount(2_000))

        profitRate shouldBe ((50_000 + 30_000_000).toDouble() / 2000)
    }
})
