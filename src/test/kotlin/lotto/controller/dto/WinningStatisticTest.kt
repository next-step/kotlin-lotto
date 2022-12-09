package lotto.controller.dto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.WinningPrize
import lotto.domain.WinningPrizes

internal class WinningStatisticTest : FunSpec({
    context("객체 생성") {
        test("당첨 금액 통계를 인자로 가지는 객체를 생성한다.") {
            val winningPrizeInfos = WinningPrize.values().map {
                WinningPrizeInfo(it.matchedCount, it.prize, it == WinningPrize.SECOND_PRIZE)
            }
            val winningPrizes = WinningPrizes(listOf(WinningPrize.SECOND_PRIZE, WinningPrize.SECOND_PRIZE, WinningPrize.THIRD_PRIZE))
            val statisticOfWinningPrize = winningPrizes.extractStatisticOfWinningPrize().mapKeys {
                WinningPrizeInfo(it.key.matchedCount, it.key.prize, it.key == WinningPrize.SECOND_PRIZE)
            }
            val firstWinningPrizeInfo = WinningPrizeInfo(WinningPrize.FIRST_PRIZE.matchedCount, WinningPrize.FIRST_PRIZE.prize, false)
            val secondWinningPrizeInfo = WinningPrizeInfo(WinningPrize.SECOND_PRIZE.matchedCount, WinningPrize.SECOND_PRIZE.prize, true)
            val thirdWinningPrizeInfo = WinningPrizeInfo(WinningPrize.THIRD_PRIZE.matchedCount, WinningPrize.THIRD_PRIZE.prize, false)

            val actual = WinningStatistic(winningPrizeInfos, statisticOfWinningPrize)

            actual.winningStatistic[firstWinningPrizeInfo]!!.count shouldBe 0
            actual.winningStatistic[secondWinningPrizeInfo]!!.count shouldBe 2
            actual.winningStatistic[thirdWinningPrizeInfo]!!.count shouldBe 1
        }
    }
})
