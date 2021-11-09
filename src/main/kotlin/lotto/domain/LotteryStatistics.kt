package lotto.domain

@JvmInline
value class LotteryStatistics private constructor(val values: Map<Ranking, Int>) {

    fun calculate(): Money {
        return Money.from(values.entries.sumOf { (key, value) -> key.reward.value.multiply(value.toBigDecimal()) })
    }

    companion object {
        private fun statisticize(lotteries: Lotteries, winningLottery: WinningLottery): Map<Ranking, Int> {
            return winningLottery.rank(lotteries)
                .groupingBy { it }
                .eachCount()
        }

        fun of(lotteries: Lotteries, winningLottery: WinningLottery): LotteryStatistics {
            return LotteryStatistics(statisticize(lotteries, winningLottery))
        }
    }
}
