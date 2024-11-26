package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class WinningBoardTest : StringSpec({
    "당첨 보드는 당첨 결과를 받아 해당 당첨 횟수를 알 수 있다" {
        val firstResults = listOf(WinningResult.FIRST)
        val secondResults =
            listOf(
                WinningResult.SECOND,
                WinningResult.SECOND,
            )
        val thirdResults =
            listOf(
                WinningResult.THIRD,
                WinningResult.THIRD,
                WinningResult.THIRD,
            )
        val fourthResults =
            listOf(
                WinningResult.FOURTH,
                WinningResult.FOURTH,
                WinningResult.FOURTH,
                WinningResult.FOURTH,
            )
        val loseResults =
            listOf(
                WinningResult.LOSE,
                WinningResult.LOSE,
                WinningResult.LOSE,
                WinningResult.LOSE,
                WinningResult.LOSE,
            )

        val winningResults =
            firstResults + secondResults + thirdResults + fourthResults + loseResults

        val sut = WinningBoard(winningResults = winningResults)

        sut.getWinningCount(WinningResult.FIRST) shouldBe firstResults.size
        sut.getWinningCount(WinningResult.SECOND) shouldBe secondResults.size
        sut.getWinningCount(WinningResult.THIRD) shouldBe thirdResults.size
        sut.getWinningCount(WinningResult.FOURTH) shouldBe fourthResults.size
        sut.getWinningCount(WinningResult.LOSE) shouldBe loseResults.size
    }

    "당첨 보드는 총 티켓 구매 비용을 받아 당첨 결과들과 비교하여 소수점 둘째 이하를 버린 수익률을 계산한다" {
        val fourthResults = listOf(WinningResult.FIFTH)
        val loseResults = List(13) { WinningResult.LOSE }
        val winningResults = fourthResults + loseResults
        val sut = WinningBoard(winningResults = winningResults)

        sut.calculateRateOfReturn(totalCost = Money(14000)).toDouble() shouldBe 0.35
    }

    "당첨 보드에서 수익률을 구할 때 총 티켓 구매 비용이 1000원 미만이면 예외를 던진다" {
        val fourthResults = listOf(WinningResult.FOURTH)
        val loseResults = List(13) { WinningResult.LOSE }
        val winningResults = fourthResults + loseResults
        val sut = WinningBoard(winningResults = winningResults)

        shouldThrow<IllegalArgumentException> { sut.calculateRateOfReturn(totalCost = Money(999)) }
    }
})
