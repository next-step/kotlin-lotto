package lottery.domain.lottery.generator

import lottery.domain.lottery.Lottery
import lottery.domain.lottery.Lottery.Companion.LOTTERY_NUMBER_SIZE
import lottery.domain.lottery.LotteryNumber

object RandomLotteryGenerator: LotteryGenerator {
    private val LOTTERY_NUMBER_CACHE = (LotteryNumber.MIN_NUMBER..LotteryNumber.MAX_NUMBER).map { LotteryNumber(it) }

    override fun generate(): Lottery = Lottery(
        LOTTERY_NUMBER_CACHE.shuffled()
            .take(LOTTERY_NUMBER_SIZE))
}
