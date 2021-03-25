package lottery.domain

class Lotteries private constructor(val lotteries: List<Lottery>) {
    companion object {
        private const val MIN_LOTTERY_COUNT = 0

        fun of(allNumbers: List<List<Int>>): Lotteries {
            require(allNumbers.size > MIN_LOTTERY_COUNT) { "입력한 로또의 개수가 올바르지 않습니다." }

            return Lotteries(allNumbers.map { Lottery(LotteryNumbers(it)) })
        }
    }
}
