package lottery.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.doubles.shouldBeExactly
import io.kotest.matchers.shouldBe
import lottery.domain.RankReward.RANK_1
import lottery.domain.RankReward.RANK_2
import lottery.domain.RankReward.RANK_4

class DrawResultTest : StringSpec({
    "당첨로또 추첨은 개수별 일치하는 로또수를 반환한다" {
        val winningLottery = WinningLottery(Lottery(LotteryNumbers(setOf(1, 2, 3, 4, 5, 6))))

        val rank1Lottery1 = Lottery(LotteryNumbers(setOf(1, 2, 3, 4, 5, 6)))
        val rank1Lottery2 = Lottery(LotteryNumbers(setOf(1, 2, 3, 4, 5, 6)))

        val rank2Lottery1 = Lottery(LotteryNumbers(setOf(1, 2, 3, 4, 5, 21)))
        val rank2Lottery2 = Lottery(LotteryNumbers(setOf(1, 2, 3, 4, 5, 22)))
        val rank2Lottery3 = Lottery(LotteryNumbers(setOf(1, 2, 3, 4, 5, 23)))

        val drawResult =
            DrawResult.from(
                winningLottery = winningLottery,
                purchaseLotteries =
                    listOf(
                        rank1Lottery1,
                        rank1Lottery2,
                        rank2Lottery1,
                        rank2Lottery2,
                        rank2Lottery3,
                    ),
            )

        drawResult.findLotteryCount(RANK_1).count shouldBe 2
        drawResult.findLotteryCount(RANK_2).count shouldBe 3
    }

    "구입 금액과 결과를 계산하여 수익률을 반환한다" {
        val drawResult = DrawResult(mapOf(RANK_4 to LotteryCount(1)))

        drawResult.getProfitRate(Money(1_000_000)) shouldBeExactly 0.005
    }
})
