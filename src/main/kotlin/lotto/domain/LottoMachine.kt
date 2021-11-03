package lotto.domain

import lotto.domain.strategy.LottoGenerator

class LottoMachine(private val generator: LottoGenerator) {

    fun count(budget: Money): Int {
        return budget.count(LOTTERY_PRICE)
    }

    fun buy(counts: Int): Lotteries {
        return (1..counts)
            .map { generator.generate() }
            .let { Lotteries.of(it) }
    }

    fun calculate(lotteries: Lotteries, winning: Lottery): LotteryStatistics {
        return LotteryStatistics.of(lotteries, winning)
    }

    fun settle(statistics: LotteryStatistics): Money {
        return statistics.calculate()
    }

    fun calculateYield(paid: Money, reward: Money): LotteryYield {
        return LotteryYield.of(paid, reward)
    }

    fun calculatePaid(counts: Int): Money {
        return Money.of(LOTTERY_PRICE.value.multiply(counts.toBigDecimal()))
    }

    companion object {
        private val LOTTERY_PRICE = Money.of(1_000L)
    }
}
