package lottery.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class WinningLotteryTest : StringSpec({
    "당첨 번호는 중복되어서는 안된다." {
        val duplicatedNumbers = listOf(1, 2, 3, 1, 4, 5)
        shouldThrow<IllegalArgumentException> {
            WinningLottery(duplicatedNumbers.map { LotteryNumber.get(it) }.toSet())
        }
    }
})
