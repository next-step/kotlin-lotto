package lottery

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe

class WinningLotteryTest : StringSpec({
    "당첨로또는 번호를 직접 입력해 생성한다" {
        val numbers = WinningLottery.create(setOf(1, 2, 3, 4, 5, 6)).lotteryNumbers.numbers
        numbers shouldContainAll listOf(1, 2, 3, 4, 5, 6)
    }

    "당첨번호와 로또번호의 일치 수를 반환한다" {
        val winningLottery = WinningLottery.create(setOf(1, 2, 3, 4, 5, 7))
        winningLottery.countMatchedNumber(listOf(1, 2, 3, 4, 5, 6)) shouldBe 5
    }
})
