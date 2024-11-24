package lottery.domain

class LotteryNumbers(val numbers: Set<Int>) {
    init {
        require(numbers.size == LOTTERY_NUMBER_COUNT) { "로또 번호는 $LOTTERY_NUMBER_COUNT 개이어야 합니다" }
        require(numbers.all { it in LOTTERY_NUMBER_RANGE }) { "로또 번호는 $LOTTERY_MIN_NUMBER 부터 $LOTTERY_MAX_NUMBER 사이어야 합니다" }
    }

    fun countMatchedNumber(other: LotteryNumbers): Int {
        return this.numbers.intersect(other.numbers).size
    }

    override fun toString(): String {
        return "$numbers"
    }

    companion object {
        private const val LOTTERY_NUMBER_COUNT = 6
        private const val LOTTERY_MIN_NUMBER = 1
        private const val LOTTERY_MAX_NUMBER = 45
        private val LOTTERY_NUMBER_RANGE = LOTTERY_MIN_NUMBER..LOTTERY_MAX_NUMBER

        fun create(): LotteryNumbers {
            val numbers = LOTTERY_NUMBER_RANGE.shuffled().take(LOTTERY_NUMBER_COUNT).sorted().toSet()
            return LotteryNumbers(numbers)
        }
    }
}
