package lottery

import io.kotest.core.spec.style.StringSpec

class Lottery(numbers: List<LotteryNumber>) {
    private var lotteryNumbers: List<LotteryNumber>

    init {
        require(hasDuplicatedLotteryNumbers(numbers)) { "로또 번호에 중복되는 숫자가 있습니다." }
        lotteryNumbers = numbers
    }

    fun makeManualLottery(numbers: List<Int>): Lottery {
        return Lottery(numbers.map { LotteryNumber(it) })
    }

    fun hasDuplicatedLotteryNumbers(numbers: List<LotteryNumber>): Boolean {
        val numbersSet = hashSetOf(numbers)
        return numbersSet.size != numbers.size
    }

    companion object {
        private val BASE_NUMBERS = (LotteryNumber.MIN_LOTTERY_NUMBER..LotteryNumber.MAX_LOTTERY_NUMBER).toList()
        private const val LOTTERY_NUMBER_SIZE = 6
        fun makeAutoLottery(): Lottery {
            return Lottery(BASE_NUMBERS.shuffled().take(LOTTERY_NUMBER_SIZE).sorted().map { LotteryNumber(it) })
        }
    }
}

data class LotteryNumber(private val number: Int) {
    init {
        require(number < MIN_LOTTERY_NUMBER) { "로또 번호는 1보다 커야합니다." }
        require(number > MAX_LOTTERY_NUMBER) { "로또 번호는 45보다 작아야합니다." }
    }

    companion object {
        const val MAX_LOTTERY_NUMBER = 45
        const val MIN_LOTTERY_NUMBER = 1
    }
}

class LotteryTest : StringSpec({
    "로또의 숫자는 6개이다." {
        val lottery = Lottery.makeAutoLottery()
        // lottery.size shouldBe 6
    }
})
