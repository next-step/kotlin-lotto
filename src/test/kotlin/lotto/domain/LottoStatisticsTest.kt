package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoStatisticsTest : StringSpec({
    "should calculate the match count for each ticket" {
        val tickets =
            listOf(
                Lotto.of(listOf(1, 2, 3, 4, 5, 6)),
                Lotto.of(listOf(1, 2, 3, 4, 5, 8)),
                Lotto.of(listOf(1, 2, 3, 4, 7, 8)),
                Lotto.of(listOf(1, 2, 3, 6, 7, 8)),
            )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        val statistics = LottoStatistics.calculate(tickets, winningNumbers)
        statistics shouldBe
            mapOf(
                6 to 1,
                5 to 1,
                4 to 2,
            )
    }

    "should calculate the total prize amount" {
        val statistics =
            mapOf(
                6 to 1,
                5 to 1,
                4 to 1,
                3 to 3,
            )

        val totalPrize = LottoStatistics.calculateTotalPrize(statistics)
        totalPrize shouldBe (2000000000 + 1500000 + 50000 + 5000 * 3)
    }
})
