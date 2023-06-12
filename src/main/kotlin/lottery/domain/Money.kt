package lottery.domain

import lottery.domain.lottery.generator.LotteryGenerator
import lottery.domain.lottery.Lotteries.Companion.toLotteries
import java.math.BigDecimal

class Money(
    val value: Int
) {
    init {
        require(value >= 0) { "돈은 음수가 입력될 수 없다" }
    }

    fun purchaseLotteries(randomLotteryGenerator: LotteryGenerator): Wallet {
        check(value >= LOTTERY_COST) { "로또를 사기엔 부족한 금액이다" }
        val purchaseCount = value.div(LOTTERY_COST)
        val randomLotteries = (0 until purchaseCount).map { randomLotteryGenerator.generate() }
            .toLotteries()
        return Wallet(LOTTERY_COST.times(purchaseCount).toBigDecimal(), randomLotteries)
    }

    companion object {
        private const val LOTTERY_COST = 1_000
    }
}
