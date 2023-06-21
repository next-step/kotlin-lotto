package lottery

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Lottery(numbers: Set<LotteryNumber>) {
    val lotteryNumbers: Set<LotteryNumber>

    init {
        require(!hasDuplicatedLotteryNumbers(numbers)) { "로또 번호에 중복되는 숫자가 있습니다." }
        lotteryNumbers = numbers
    }

    private fun hasDuplicatedLotteryNumbers(numbers: Set<LotteryNumber>): Boolean {
        return numbers.size != LOTTERY_NUMBER_SIZE
    }

    companion object {
        private val BASE_NUMBERS = (LotteryNumber.MIN_LOTTERY_NUMBER..LotteryNumber.MAX_LOTTERY_NUMBER).toSet()
        private const val LOTTERY_NUMBER_SIZE = 6
        fun makeAutoLottery(): Lottery {
            return Lottery(
                BASE_NUMBERS.shuffled().take(LOTTERY_NUMBER_SIZE).sorted().map { LotteryNumber.get(it) }
                    .toSet()
            )
        }
    }
}

@JvmInline
value class LotteryNumber private constructor(
    private val number: Int,
) {
    init {
        require(number >= MIN_LOTTERY_NUMBER) { "로또 번호는 1이상여야 합니다." }
        require(number <= MAX_LOTTERY_NUMBER) { "로또 번호는 45이하이여야 합니다." }
    }

    companion object {
        fun get(number: Int) = LotteryNumber(number)

        const val MAX_LOTTERY_NUMBER = 45
        const val MIN_LOTTERY_NUMBER = 1
    }
}

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
})
