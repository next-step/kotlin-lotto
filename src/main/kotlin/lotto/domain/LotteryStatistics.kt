package lotto.domain

@JvmInline
value class LotteryStatistics private constructor(val values: Map<Ranking, Int>) {

    fun calculate(): Money {
        return Money.of(values.entries.sumOf { (key, value) -> key.reward.value.multiply(value.toBigDecimal()) })
    }

    companion object {
        private fun statisticize(lotteries: Lotteries, winning: Lottery): Map<Ranking, Int> {
            return lotteries.values.map { Ranking.calculate(it.compareTo(winning)) }
                .groupingBy { it }
                .eachCount()
        }

        fun of(lotteries: Lotteries, winning: Lottery): LotteryStatistics {
            return LotteryStatistics(statisticize(lotteries, winning))
        }
    }
}
