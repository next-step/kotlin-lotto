package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class WinningNumberTest : DescribeSpec({
    val fourthPrizePrice = 5000
    val thirdPrizePrice = 50_000
    val secondPrizePrice = 1_500_000
    val firstPrizePrice = 2_000_000_000

    describe("match") {
        it("지난 주 로또 당첨 번호와 3개의 숫자가 맞으면 4등이다") {
            val lastWeekWinningNumbers = listOf(1, 2, 3, 4, 5, 6)
            val lottos = listOf(listOf(1, 2, 3, 9, 10, 11))
            val purchaseAmount = 14000

            val winningNumber = WinningNumber(lastWeekWinningNumbers)

            val expectResult = winningNumber.match(purchaseAmount, lottos)

            expectResult.fourthPrize.numberOfCorrect shouldBe 1
            expectResult.thirdPrize.numberOfCorrect shouldBe 0
            expectResult.secondPrize.numberOfCorrect shouldBe 0
            expectResult.firstPrize.numberOfCorrect shouldBe 0
            expectResult.rateOfReturn shouldBe String.format("%.2f", fourthPrizePrice / purchaseAmount.toDouble())
        }

        it("지난 주 로또 당첨 번호와 4개의 숫자가 맞으면 3등이다") {
            val lastWeekWinningNumbers = listOf(1, 2, 3, 4, 5, 6)
            val lottos = listOf(listOf(1, 2, 3, 4, 10, 11))
            val purchaseAmount = 14000

            val winningNumber = WinningNumber(lastWeekWinningNumbers)

            val expectResult = winningNumber.match(purchaseAmount, lottos)

            expectResult.fourthPrize.numberOfCorrect shouldBe 0
            expectResult.thirdPrize.numberOfCorrect shouldBe 1
            expectResult.secondPrize.numberOfCorrect shouldBe 0
            expectResult.firstPrize.numberOfCorrect shouldBe 0
            expectResult.rateOfReturn shouldBe String.format("%.2f", thirdPrizePrice / purchaseAmount.toDouble())
        }

        it("지난 주 로또 당첨 번호와 5개의 숫자가 맞으면 2등이다") {
            val lastWeekWinningNumbers = listOf(1, 2, 3, 4, 5, 6)
            val lottos = listOf(listOf(1, 2, 3, 4, 5, 11))
            val purchaseAmount = 14000

            val winningNumber = WinningNumber(lastWeekWinningNumbers)

            val expectResult = winningNumber.match(purchaseAmount, lottos)

            expectResult.fourthPrize.numberOfCorrect shouldBe 0
            expectResult.thirdPrize.numberOfCorrect shouldBe 0
            expectResult.secondPrize.numberOfCorrect shouldBe 1
            expectResult.firstPrize.numberOfCorrect shouldBe 0
            expectResult.rateOfReturn shouldBe String.format("%.2f", secondPrizePrice / purchaseAmount.toDouble())
        }

        it("지난 주 로또 당첨 번호와 6개의 숫자가 맞으면 1등이다") {
            val lastWeekWinningNumbers = listOf(1, 2, 3, 4, 5, 6)
            val lottos = listOf(listOf(1, 2, 3, 4, 5, 6))
            val purchaseAmount = 14000

            val winningNumber = WinningNumber(lastWeekWinningNumbers)

            val expectResult = winningNumber.match(purchaseAmount, lottos)

            expectResult.fourthPrize.numberOfCorrect shouldBe 0
            expectResult.thirdPrize.numberOfCorrect shouldBe 0
            expectResult.secondPrize.numberOfCorrect shouldBe 0
            expectResult.firstPrize.numberOfCorrect shouldBe 1
            expectResult.rateOfReturn shouldBe String.format("%.2f", firstPrizePrice / purchaseAmount.toDouble())
        }

        it("지난 주 로또 당첨 번호와 2개이하의 숫자가 맞으면 꽝이다.") {
            val lastWeekWinningNumbers = listOf(1, 2, 3, 4, 5, 6)
            val lottos = listOf(listOf(5, 6, 7, 8, 9, 10), listOf(6, 7, 8, 9, 10, 11))
            val purchaseAmount = 14000

            val winningNumber = WinningNumber(lastWeekWinningNumbers)

            val expectResult = winningNumber.match(purchaseAmount, lottos)

            expectResult.fourthPrize.numberOfCorrect shouldBe 0
            expectResult.thirdPrize.numberOfCorrect shouldBe 0
            expectResult.secondPrize.numberOfCorrect shouldBe 0
            expectResult.firstPrize.numberOfCorrect shouldBe 0
            expectResult.rateOfReturn shouldBe "0.00"
        }
    }
})
