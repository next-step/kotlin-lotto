package domain

class LotteryNumbers {
    var numbers: Set<Int> = HashSet(LOTTERY_NUMBERS_SIZE)
    private set

    init {
        require(numbers.size == 6) { "숫자는 6개 이상이여야 합니다." }
    }

    fun makeLotteryNumbers(lotteryNumbers: Numbers): HashSet<Int> {
        numbers = lotteryNumbers.makeNumbers(LOTTERY_NUMBERS_SIZE)
        return numbers as HashSet<Int>
    }

    companion object {
        private const val LOTTERY_NUMBERS_SIZE = 6
    }
}
