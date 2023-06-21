package lottery

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Lottery(numbers: List<LotteryNumber>) {
    val lotteryNumbers: List<LotteryNumber>

    init {
        require(!hasDuplicatedLotteryNumbers(numbers)) { "로또 번호에 중복되는 숫자가 있습니다." }
        lotteryNumbers = numbers
    }

    fun makeManualLottery(numbers: List<Int>): Lottery {
        return Lottery(numbers.map { LotteryNumber(it) })
    }

    private fun hasDuplicatedLotteryNumbers(numbers: List<LotteryNumber>): Boolean {
        return numbers.size != LOTTERY_NUMBER_SIZE
    }

    companion object {
        private val BASE_NUMBERS = (LotteryNumber.MIN_LOTTERY_NUMBER..LotteryNumber.MAX_LOTTERY_NUMBER).toList()
        private const val LOTTERY_NUMBER_SIZE = 6
        fun makeAutoLottery(): Lottery {
            return Lottery(BASE_NUMBERS.shuffled().take(LOTTERY_NUMBER_SIZE).sorted().map { LotteryNumber(it) })
        }
    }
}

@JvmInline
value class LotteryNumber(private val number: Int) {
    init {
        require(number >= MIN_LOTTERY_NUMBER) { "로또 번호는 1이상여야 합니다." }
        require(number <= MAX_LOTTERY_NUMBER) { "로또 번호는 45이하이여야 합니다." }
    }

    companion object {
        const val MAX_LOTTERY_NUMBER = 45
        const val MIN_LOTTERY_NUMBER = 1
    }
}

class LotteryTest : StringSpec({
    "자동 로또 생성을 할 경우의 숫자의 개수는 6개이다." {
        val lottery = Lottery.makeAutoLottery()
        lottery.lotteryNumbers.size shouldBe 6
    }
})
