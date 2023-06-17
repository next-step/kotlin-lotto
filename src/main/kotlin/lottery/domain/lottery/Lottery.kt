package lottery.domain.lottery

import lottery.domain.Money
import lottery.domain.Receipt
import java.math.BigDecimal

class Lottery(
    val values: List<LotteryNumber>,
) {
    init {
        require(values.size == LOTTERY_NUMBER_SIZE) { "로또 번호는 6개만 입력하여야한다" }
        require(values.distinct().size == LOTTERY_NUMBER_SIZE) { "로또 번호는 중복되어 입력될 수 없다" }
    }

    fun matchCount(lottery: Lottery): Int = values.count { lottery.values.contains(it) }

    fun containsLotteryNumber(lotteryNumber: LotteryNumber): Boolean = values.contains(lotteryNumber)

    companion object {
        const val LOTTERY_NUMBER_SIZE = 6
        val LOTTERY_COST = Money(BigDecimal(1_000))

        fun from(values: List<String>): Lottery = Lottery(values.map { LotteryNumber.from(it) })

        fun purchaseLottery(money: Money): Receipt {
            val purchaseCount = countOfCanPurchaseLottery(money).toInt()
            return Receipt(LOTTERY_COST.times(purchaseCount), purchaseCount)
        }

        fun canPurchaseLottery(money: Money): Boolean = countOfCanPurchaseLottery(money) > BigDecimal.ZERO

        fun canPurchaseLottery(purchaseCount: Int, money: Money): Boolean =
            countOfCanPurchaseLottery(money) >= purchaseCount.toBigDecimal()

        private fun countOfCanPurchaseLottery(money: Money): BigDecimal = money.divide(LOTTERY_COST)
    }
}
