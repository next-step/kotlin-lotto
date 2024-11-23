package lottery

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LotteryTest : StringSpec({
    "로또번호끼리의 일치 수를 반환한다" {
        val lottery = Lottery(LotteryNumbers(setOf(1, 2, 3, 4, 5, 6)))
        val other = Lottery(LotteryNumbers(setOf(1, 2, 3, 4, 5, 7)))
        lottery.countMatchedNumber(other) shouldBe 5
    }
})
