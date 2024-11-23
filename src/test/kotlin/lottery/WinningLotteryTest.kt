package lottery

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainAll

class WinningLotteryTest: StringSpec({
    "당첨로또는 번호를 직접 입력해 생성한다" {
        val numbers = WinningLottery.create(listOf(1,2,3,4,5,6)).lotteryNumbers.numbers
        numbers shouldContainAll listOf(1,2,3,4,5,6)
    }
})
