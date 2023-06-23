package domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe

class LotteryTest : StringSpec({
    "복권 생성시 랜덤 값 6개가 생성된다." {
        val lottery = Lottery()
        lottery.lotteryNumbers.size shouldBe 6
    }

    "복권 랜덤 값은 1부터 45 사이 값이다." {
        val lottery = Lottery()
        lottery.lotteryNumbers.forEach { it shouldBeInRange 1..45 }
    }
})
