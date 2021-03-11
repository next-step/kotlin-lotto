package domain

class Lotteries(var lotteries: List<Lottery>) {
    companion object {
        fun createLotteries(count: Int): Lotteries {
            return Lotteries((1..count).map { Lottery(LotteryNumbers(listOf(1, 2))) })
        }
    }
}
