package lottery.domain.lottery.generator

import lottery.domain.lottery.Lottery

interface LotteryGenerator {
    fun generate(): Lottery

    fun generateLotteries(count: Int): List<Lottery>
}
