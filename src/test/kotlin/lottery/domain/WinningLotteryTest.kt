package lottery.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainAll

class WinningLotteryTest : StringSpec({
    "당첨로또는 번호를 직접 입력해 생성한다" {
        val winningLottery = WinningLottery(LotteryNumbers(setOf(1, 2, 3, 4, 5, 6)))
        winningLottery.lotteryNumbers.numbers shouldContainAll setOf(1, 2, 3, 4, 5, 6)
    }
})
