package lottery

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
        const val LOTTERY_PRICE = 1000
        fun makeAutoLottery(): Lottery {
            return Lottery(
                BASE_NUMBERS.shuffled().take(LOTTERY_NUMBER_SIZE).sorted().map { LotteryNumber.get(it) }
                    .toSet()
            )
        }
    }
}
