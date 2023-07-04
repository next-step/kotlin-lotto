package lottery.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LotteryTest : StringSpec({
    "자동 로또 생성을 할 경우의 숫자의 개수는 6개이다." {
        val lottery = Lottery.makeAutoLottery()
        lottery.lotteryNumbers.size shouldBe 6
    }

    "로또는 번호는 중복돼서는 안된다." {
        val duplicatedNumbers = listOf(1, 2, 3, 1, 4, 5)
        shouldThrow<IllegalArgumentException> {
            Lottery(duplicatedNumbers.map { LotteryNumber.get(it) }.toSet())
        }
    }

    "로또 한장의 금액은 1000원 이다." {
        Lottery.LOTTERY_PRICE shouldBe 1000
    }

    "로또 두개를 비교했을때 맞는 개수를 정확하게 가져와야한다." {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val winningNumbers = listOf(1, 2, 3, 8, 9, 10)
        val lottery = Lottery(numbers.map { LotteryNumber.get(it) }.toSet())
        val winningLottery = WinningLottery(winningNumbers.map { LotteryNumber.get(it) }.toSet())
        lottery.checkCorrectCount(winningLottery.winningNumbers) shouldBe 3
    }
})
