package lottery.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LotteryRankTest : StringSpec({
    "plusRank 호출시 해당하는 로또 등수를 올려주어야한다." {
        val lotteryRank = LotteryRank()
        lotteryRank.lotteriesRank[LotteryPrize.THIRD] shouldBe 0
        lotteryRank.plusRank(LotteryPrize.THIRD)
        lotteryRank.lotteriesRank[LotteryPrize.THIRD] shouldBe 1
    }

    "로또 구매 금액과 수익금으로 수익률(금액 / 구매금액)을 계산해 주어야한다." {
        val lotteryRank = LotteryRank()
        lotteryRank.calculateProfit(1000) shouldBe 0
        lotteryRank.plusRank(LotteryPrize.FORTH)
        lotteryRank.calculateProfit(1000) shouldBe 5
    }
})
