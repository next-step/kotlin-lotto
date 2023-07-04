package lottery

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lottery.domain.LotteryPrize
import lottery.domain.LotteryRank

class LotteryRankTest : StringSpec({
    "plus호출시 해당하는 로또 등수를 올려주어야한다." {
        val lotteryRank = LotteryRank()
        lotteryRank.plusRank(LotteryPrize.THIRD) shouldBe 1
    }
})
