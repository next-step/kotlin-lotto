package lotto

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class AnalystTest : DescribeSpec({
    describe("analyze") {
        it("지난 주 로또 당첨 번호와 3개의 숫자가 맞으면 4등이다") {
            val lastWeekWinningNumbers = listOf(1, 2, 3, 4, 5, 6)
            val lottos = listOf(listOf(1, 2, 3, 9, 10, 11))
            val purchaseAmount = 14000

            val analyst = Analyst(lastWeekWinningNumbers)

            analyst.analyze(purchaseAmount, lottos)

            analyst.result["3"] shouldBe listOf(5000, 1)
            analyst.result["4"] shouldBe listOf(50000, 0)
            analyst.result["5"] shouldBe listOf(1500000, 0)
            analyst.result["6"] shouldBe listOf(2000000000, 0)
            analyst.result["bf"] shouldBe String.format("%.2f", 5000 / purchaseAmount.toDouble())
        }

        it("지난 주 로또 당첨 번호와 4개의 숫자가 맞으면 3등이다") {
            val lastWeekWinningNumbers = listOf(1, 2, 3, 4, 5, 6)
            val lottos = listOf(listOf(1, 2, 3, 4, 10, 11))
            val purchaseAmount = 14000

            val analyst = Analyst(lastWeekWinningNumbers)

            analyst.analyze(purchaseAmount, lottos)

            analyst.result["3"] shouldBe listOf(5000, 0)
            analyst.result["4"] shouldBe listOf(50000, 1)
            analyst.result["5"] shouldBe listOf(1500000, 0)
            analyst.result["6"] shouldBe listOf(2000000000, 0)
            analyst.result["bf"] shouldBe String.format("%.2f", 50000 / purchaseAmount.toDouble())
        }

        it("지난 주 로또 당첨 번호와 5개의 숫자가 맞으면 2등이다") {
            val lastWeekWinningNumbers = listOf(1, 2, 3, 4, 5, 6)
            val lottos = listOf(listOf(1, 2, 3, 4, 5, 11))
            val purchaseAmount = 14000

            val analyst = Analyst(lastWeekWinningNumbers)

            analyst.analyze(purchaseAmount, lottos)

            analyst.result["3"] shouldBe listOf(5000, 0)
            analyst.result["4"] shouldBe listOf(50000, 0)
            analyst.result["5"] shouldBe listOf(1500000, 1)
            analyst.result["6"] shouldBe listOf(2000000000, 0)
            analyst.result["bf"] shouldBe String.format("%.2f", 1500000 / purchaseAmount.toDouble())
        }

        it("지난 주 로또 당첨 번호와 6개의 숫자가 맞으면 1등이다") {
            val lastWeekWinningNumbers = listOf(1, 2, 3, 4, 5, 6)
            val lottos = listOf(listOf(1, 2, 3, 4, 5, 6))
            val purchaseAmount = 14000

            val analyst = Analyst(lastWeekWinningNumbers)

            analyst.analyze(purchaseAmount, lottos)

            analyst.result["3"] shouldBe listOf(5000, 0)
            analyst.result["4"] shouldBe listOf(50000, 0)
            analyst.result["5"] shouldBe listOf(1500000, 0)
            analyst.result["6"] shouldBe listOf(2000000000, 1)
            analyst.result["bf"] shouldBe String.format("%.2f", 2000000000 / purchaseAmount.toDouble())
        }
    }
})
