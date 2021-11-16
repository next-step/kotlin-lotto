package lotto.domain

import lotto.domain.strategy.LottoNumberAutoGenerator
import lotto.domain.strategy.LottoNumberGenerator

class LottoMachine(private val generator: LottoNumberGenerator = LottoNumberAutoGenerator) {

    fun count(budget: Money): Int {
        return budget.count(LOTTERY_PRICE)
    }

    private fun manualTicketing(selected: List<LottoNumbers>): Lotteries {
        return selected
            .map { Lottery.of(it) }
            .run { Lotteries.of(this) }
    }

    private fun automaticTicketing(counts: Int): Lotteries {
        return (1..counts)
            .map { generator.generate() }
            .map { Lottery.of(it) }
            .run { Lotteries.of(this) }
    }

    fun buy(order: Order): Lotteries {
        return manualTicketing(order.selected) + automaticTicketing(order.auto)
    }

    fun calculate(lotteries: Lotteries, winningLottery: WinningLottery): LotteryStatistics {
        return LotteryStatistics.of(lotteries, winningLottery)
    }

    fun settle(statistics: LotteryStatistics): Money {
        return statistics.calculate()
    }

    fun calculateYield(paid: Money, reward: Money): LotteryYield {
        return LotteryYield.of(paid, reward)
    }

    fun calculatePaid(order: Order): Money {
        return Money.from(LOTTERY_PRICE.value.multiply(order.total().toBigDecimal()))
    }

    companion object {
        private val LOTTERY_PRICE = Money.from(1_000L)
    }
}
