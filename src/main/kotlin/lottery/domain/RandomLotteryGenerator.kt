package lottery.domain

import lottery.domain.Lottery.Companion.LOTTERY_NUMBER_SIZE

object RandomLotteryGenerator: LotteryGenerator {
    private val LOTTERY_NUMBER_CACHE = (LotteryNumber.MIN_NUMBER..LotteryNumber.MAX_NUMBER).map { LotteryNumber(it) }

    override fun generate(): Lottery = Lottery(LOTTERY_NUMBER_CACHE.shuffled()
            .take(LOTTERY_NUMBER_SIZE))
}
