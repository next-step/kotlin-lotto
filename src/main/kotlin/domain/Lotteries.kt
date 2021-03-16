package domain

class Lotteries(val lotteries: List<Lottery>) {
    companion object {
        private const val START_LOTTERY_COUNT = 1
        private const val MIN_LOTTERY_NUMBER = 1
        private const val MAX_LOTTERY_NUMBER = 45
        private const val LOTTERY_SIZE = 6
        private const val MIN_LOTTERY_COUNT = 0

        fun of(count: Int): Lotteries {
            require(count > MIN_LOTTERY_COUNT) { "입력한 로또의 개수가 올바르지 않습니다." }

            return Lotteries(
                (START_LOTTERY_COUNT..count).map {
                    Lottery(LotteryNumbers(generateRandoms()))
                }
            )
        }

        private fun generateRandoms() = RandomNumbers.generate(MIN_LOTTERY_NUMBER, MAX_LOTTERY_NUMBER, LOTTERY_SIZE)
    }
}
