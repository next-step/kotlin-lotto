package domain

class Lotteries(var lotteries: List<Lottery>) {
    companion object {
        fun of(count: Int): Lotteries {
            val random = RandomNumbers()
            return Lotteries((1..count).map { Lottery(LotteryNumbers(random.makeNumbers(1, 45, 6))) })
        }
    }
}
