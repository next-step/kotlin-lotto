package domain

class Lotteries(var lotteries: List<Lottery>) {
    companion object {
        fun of(count: Int): Lotteries {
            return Lotteries((1..count).map { Lottery(LotteryNumbers.of(RandomNumbers())) })
        }
    }
}
