package lottery.domain

class Lotteries private constructor(val lotteries: List<Lottery>) {
    companion object {
        private const val START_LOTTERY_COUNT = 1
        private const val MIN_LOTTERY_COUNT = 0

        fun of(count: Int, numbers: List<Int>): Lotteries {
            require(count > MIN_LOTTERY_COUNT) { "입력한 로또의 개수가 올바르지 않습니다." }

            return Lotteries(
                (START_LOTTERY_COUNT..count).map {
                    Lottery(LotteryNumbers(numbers))
                }
            )
        }
    }
}
