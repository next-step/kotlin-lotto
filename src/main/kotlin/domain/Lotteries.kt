package domain

class Lotteries(var lotteries: List<Lottery>) {
    companion object {
        private const val MIN_LOTTERY_NUMBER = 1
        private const val MAX_LOTTERY_NUMBER = 45
        private const val LOTTERY_SIZE = 6

        fun of(count: Int): Lotteries {
            val randoms = RandomNumbers.generate(MIN_LOTTERY_NUMBER, MAX_LOTTERY_NUMBER, LOTTERY_SIZE)
            return Lotteries((1..count).map { Lottery(LotteryNumbers(randoms)) })
        }
    }
}
