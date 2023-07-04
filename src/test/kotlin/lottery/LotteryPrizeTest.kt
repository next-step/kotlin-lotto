package lottery

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lottery.domain.LotteryPrize

class LotteryPrizeTest : StringSpec({
    "correctCount 갯수에 해당하는 LotteryPrize 를 가져와야한다." {
        LotteryPrize.get(3) shouldBe LotteryPrize.FORTH
        LotteryPrize.get(4) shouldBe LotteryPrize.THIRD
        LotteryPrize.get(5) shouldBe LotteryPrize.SECOND
        LotteryPrize.get(6) shouldBe LotteryPrize.FIRST
    }
})
