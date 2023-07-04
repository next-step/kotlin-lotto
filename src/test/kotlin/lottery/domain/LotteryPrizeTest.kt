package lottery.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LotteryPrizeTest : StringSpec({
    "correctCount 갯수에 해당하는 LotteryPrize 를 가져와야한다." {
        LotteryPrize.get(correctCount = 3) shouldBe LotteryPrize.FORTH
        LotteryPrize.get(correctCount = 4) shouldBe LotteryPrize.THIRD
        LotteryPrize.get(correctCount = 5) shouldBe LotteryPrize.SECOND
        LotteryPrize.get(correctCount = 6) shouldBe LotteryPrize.FIRST
    }
})
