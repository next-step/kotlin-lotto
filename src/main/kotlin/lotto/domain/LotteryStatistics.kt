package lotto.domain

@JvmInline
value class LotteryStatistics private constructor(val values: Map<Ranking, Int>) {

    fun calculate(): Money {
        return Money.from(values.entries.sumOf { (key, value) -> key.reward.value.multiply(value.toBigDecimal()) })
    }

    companion object {
        private fun statisticize(lotteries: Lotteries, winning: Lottery, bonusBall: BonusBall): Map<Ranking, Int> {
            return lotteries.rank(winning, bonusBall)
                .groupingBy { it }
                .eachCount()
        }

        fun of(lotteries: Lotteries, winning: Lottery, bonusBall: BonusBall): LotteryStatistics {
            return LotteryStatistics(statisticize(lotteries, winning, bonusBall))
        }
    }
}
