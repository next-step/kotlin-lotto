package lotto

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
})
