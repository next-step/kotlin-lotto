package domain

class LotteryNumbers(val numbers: HashSet<LotteryNumber>) {
    init {
        require(numbers.size == LOTTERY_NUMBERS_SIZE) { "숫자는 ${LOTTERY_NUMBERS_SIZE}개 이상이여야 합니다." }
    }

    companion object {
        private const val START_INDEX = 0
        private const val LOTTERY_NUMBERS_SIZE = 6

        fun of(number: Numbers): LotteryNumbers {
            val numbers = (START_INDEX..LOTTERY_NUMBERS_SIZE)
                .map { LotteryNumber.from(number) }
                .toHashSet()

            return LotteryNumbers(numbers)
        }
    }
}
